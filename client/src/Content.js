import React from 'react';
import axios from 'axios';
import TeamSelect from './TeamSelect.js';
import Sprint from './Sprint.js';
import Capacity from './Capacity.js'
import Velocity from './Velocity.js'
import TeamTable from './TeamTable.js';
import VelocityTable from './VelocityTable.js';
import Loader from './Loader.js';
import Message from './Message.js';
import { buildAvailableCapacityPostData, buildTeamData, getForcastedStoryPoints } from './Utils.js';

export default class Content extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading: false,
            teamNames: [],
            showTeamDetails: false,
            selectedTeamDetails: {},
            teamSprintDetails: [],
            placeHolderValue: 'Select',
            maxCapacity: 0,
            noSprintsFound: false,
            availableCapacity: 0,
            teamData: [],
            forcastedStoryPoints: 0,
        }
    }

    componentDidMount() {
        this.setState({ loading: true });
        axios.get(`${this.props.baseURL}/kronosteams`)
            .then(res => {
                this.setState({
                    loading: false,
                    teamNames: res.data,
                })
            })
            .catch((err) => {
                this.setState({
                    loading: false,
                    teamNames: { error: err }
                })
            })
    }

    getTeamDetails = (teamValue) => {
        this.setState({
            loading: true,
            placeHolderValue: teamValue.name + ' - ' + teamValue.lead,
            noSprintsFound: false
        });

        axios.post(`${this.props.baseURL}/kronossprints`, teamValue.name, { headers: { "Content-Type": "text/plain" } })
            .then(res => {
                if (res.data && res.data.length > 0) {
                    this.getResources(teamValue.id);
                    this.setState({
                        teamSprintDetails: res.data,
                        showTeamDetails: true
                    })
                } else {
                    this.setState({
                        loading: false,
                        showTeamDetails: false,
                        noSprintsFound: true
                    })
                }
            })
            .catch(err => {
                this.setState({
                    loading: false,
                    teamSprintDetails: { error: err }
                })
            })
    }

    getResources = (teamId) => {
        axios.get(`${this.props.baseURL}/kronosteams/resources/${teamId}`)
            .then(res => {

                const teamData = buildTeamData(res.data);
                const teamSize = res?.data?.teamMembers?.length;
                this.getMaxCapacity(teamSize);

                this.setState({
                    selectedTeamDetails: res.data,
                    teamData: teamData,
                    teamSize: teamSize
                })

            })
            .catch((err) => {
                this.setState({
                    loading: false,
                    selectedTeamDetails: { error: err }
                })
            })
    }

    getMaxCapacity = (teamSize, daysInSprint, hoursPerDay) => {
        const { teamSprintDetails } = this.state;
        const daysInSprintVal = daysInSprint ? daysInSprint : 11;
        const hoursPerDayVal = hoursPerDay ? hoursPerDay : 6;

        axios.get(`${this.props.baseURL}/max-capacity/${teamSize}/${daysInSprintVal}/${hoursPerDayVal}`)
            .then(res => {
                const forcastedStoryPoints = getForcastedStoryPoints(teamSprintDetails, res.data)

                this.setState({
                    loading: false,
                    showTeamDetails: true,
                    maxCapacity: res.data,
                    availableCapacity: res.data,
                    forcastedStoryPoints: forcastedStoryPoints,
                    daysInSprint: daysInSprintVal,
                    hoursPerDay: hoursPerDayVal
                })
            })
            .catch((err) => {
                this.setState({
                    loading: false,
                    daysInSprint: daysInSprintVal,
                    hoursPerDay: hoursPerDayVal
                })
            })
    }

    getAvailableCapacity = (value, teamMember, valueType) => {

        const { teamData, teamSprintDetails, hoursPerDay, daysInSprint } = this.state;
        const postData = buildAvailableCapacityPostData(value, teamMember, teamData, valueType);

        axios.post(`${this.props.baseURL}/available-capacity/${daysInSprint}/${hoursPerDay}`, postData)
            .then(res => {
                const forcastedStoryPoints = getForcastedStoryPoints(teamSprintDetails, res.data)

                this.setState({
                    loading: false,
                    availableCapacity: res.data,
                    forcastedStoryPoints: forcastedStoryPoints
                })
            })
            .catch((err) => {
                this.setState({
                    loading: false,
                })
            })
    }

    render() {

        const { loading, teamNames, showTeamDetails, selectedTeamDetails, placeHolderValue, maxCapacity, teamSprintDetails, noSprintsFound, availableCapacity, forcastedStoryPoints, teamSize, daysInSprint, hoursPerDay } = this.state;

        const activeSprint = teamSprintDetails?.filter((item) => item.sprint?.state === 'ACTIVE');
        const closedSprints = teamSprintDetails?.filter((item) => item.sprint?.state !== 'ACTIVE');

        const noSprintFoundMessage = "No Sprints Found associated with the team selected."

        return (
            <>
                {loading && <Loader />}

                <TeamSelect teamNames={teamNames} getTeamDetails={this.getTeamDetails} placeHolderValue={placeHolderValue} />

                {
                    showTeamDetails ?
                        <>
                            <div className="row">
                                <Sprint activeSprint={activeSprint} getMaxCapacity={this.getMaxCapacity} teamSize={teamSize} />
                                <Capacity maxCapacity={maxCapacity} availableCapacity={availableCapacity} />
                                <Velocity forcastedStoryPoints={forcastedStoryPoints} />
                            </div>
                            <div className="row">
                                <TeamTable selectedTeamDetails={selectedTeamDetails} getAvailableCapacity={this.getAvailableCapacity} daysInSprint={daysInSprint} hoursPerDay={hoursPerDay} />
                                <VelocityTable closedSprints={closedSprints} />
                            </div>
                        </>
                        :
                        noSprintsFound ?
                            <Message msg={noSprintFoundMessage} />
                            :
                            <></>
                }
            </>
        )
    }
}