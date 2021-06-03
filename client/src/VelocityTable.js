import React from 'react';

export default class VelocityTable extends React.Component {

    getStoryPoints = (value) => {
        let storyPointsForSprint = 0;

        value?.contents?.completedIssues?.map((val) => {
            if (val?.estimateStatistic?.statFieldValue?.value !== undefined) {
                storyPointsForSprint += val.estimateStatistic.statFieldValue.value
            }
        })

        return storyPointsForSprint
    }

    render() {
        const { closedSprints } = this.props;

        return (
            <div className="col-lg-4 col-md-12">
                <div className="card ">
                    <div className="card-header">
                        <h4 className="card-title">Velocity for Past Sprints</h4>
                    </div>
                    <div className="card-body">
                        <div className="table-responsive">
                            <table className="table tablesorter " id="">
                                <thead className=" text-primary">
                                    <tr>
                                        <th>Sprints</th>
                                        <th>Capacity</th>
                                        <th>Story Points</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {closedSprints && closedSprints.length > 0 &&
                                        closedSprints.map((value, index) => {
                                            return (
                                                <tr key={index}>
                                                    <td>{value?.sprint?.name}</td>
                                                    <td>{value?.sprintCapacity?.capacity}</td>
                                                    <td>{this.getStoryPoints(value)}</td>
                                                </tr>
                                            )
                                        })}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}