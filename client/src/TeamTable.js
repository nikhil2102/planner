import React from 'react';
import { getCalculatedData } from './Utils.js'

export default class TeamTable extends React.Component {

    render() {
        const { selectedTeamDetails, getAvailableCapacity, daysInSprint, hoursPerDay } = this.props;

        return (
            <div className="col-lg-12">
                <div className="card ">
                    <div className="card-header">
                        <h4 className="card-title">Team Details</h4>
                    </div>
                    <div className="card-body">
                        <div className="table-responsive">
                            <table className="table tablesorter " id="">
                                <thead className="text-primary">
                                    <tr>
                                        <th></th>
                                        <th>Name</th>
                                        <th>Role</th>
                                        <th>Absence</th>
                                        <th>Available Hours</th>
                                        <th>Capacity (%)</th>
                                        <th>availability (%)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {selectedTeamDetails && Object.keys(selectedTeamDetails).length > 0 &&
                                        selectedTeamDetails.teamMembers && selectedTeamDetails.teamMembers.length > 0 &&
                                        selectedTeamDetails.teamMembers.map((item, index) => {

                                            function getAvailability(value, valueType) {
                                                // value will be boolean when checkbox in clicked and will be string for input number box
                                                if (typeof value === "boolean") {
                                                    document.getElementById("absence_" + index).value = "0"
                                                    if (value) {
                                                        item.disabled = true;
                                                        item.availableHours = "0";
                                                        item.capacity = "0";
                                                        item.availability = document.getElementById("availability_" + index).value = "0";
                                                    } else {
                                                        item.disabled = false;
                                                        item.availableHours = daysInSprint * hoursPerDay;
                                                        item.capacity = "100";
                                                        item.availability = document.getElementById("availability_" + index).value = "100";
                                                    }
                                                } else {
                                                    let data;

                                                    if (valueType === "absence") {
                                                        const availability = document.getElementById("availability_" + index).value;
                                                        const absence = value;

                                                        data = getCalculatedData(daysInSprint, hoursPerDay, absence, availability);
                                                    } else if (valueType === "availability") {
                                                        const availability = value;
                                                        const absence = document.getElementById("absence_" + index).value;

                                                        data = getCalculatedData(daysInSprint, hoursPerDay, absence, availability);
                                                    }

                                                    item.disabled = false;
                                                    item.availableHours = Math.floor(data.availableHours);
                                                    item.capacity = Math.floor(data.capacity);
                                                    item.availability = document.getElementById("availability_" + index).value
                                                }
                                            }

                                            const disabledClass = item.disabled && "disabled-color"

                                            return (
                                                <tr key={index}>

                                                    <td className={disabledClass}>
                                                        <div className="form-check">
                                                            <label className="form-check-label">
                                                                <input className="form-check-input" type="checkbox" onClick={(elem) => {
                                                                    getAvailableCapacity(elem.target.checked, item);
                                                                    getAvailability(elem.target.checked);
                                                                }}
                                                                />
                                                                <span className="form-check-sign">
                                                                    <span className="check"></span>
                                                                </span>
                                                            </label>
                                                        </div>
                                                    </td>

                                                    <td className={disabledClass}>
                                                        {item.displayname}
                                                    </td>

                                                    <td className={disabledClass}>
                                                        {item.memberships[0].role.name}
                                                    </td>

                                                    <td className={item.disabled && disabledClass + " nonClickable"}>
                                                        <input
                                                            id={"absence_" + index}
                                                            className="form-control valid"
                                                            type="number"
                                                            min="0"
                                                            max={daysInSprint}
                                                            aria-invalid="false"
                                                            defaultValue="0"
                                                            onBlur={(elem) => {
                                                                getAvailableCapacity(elem.target.value, item, "absence");
                                                                getAvailability(elem.target.value, "absence")
                                                            }}
                                                            onKeyDown={(event) => event.preventDefault()}
                                                        />
                                                    </td>

                                                    <td id={"availableHours_" + index} className={"text-center " + disabledClass}>
                                                        {item.availableHours ? item.availableHours : daysInSprint * hoursPerDay}
                                                    </td>

                                                    <td id={"capacity_" + index} className={"text-center " + disabledClass}>
                                                        {(item.capacity ? item.capacity : 100) + ' %'}
                                                    </td>

                                                    <td className={disabledClass}>
                                                        <input
                                                            id={"availability_" + index}
                                                            className="form-control valid"
                                                            type="number"
                                                            min="0"
                                                            max="100"
                                                            aria-invalid="false"
                                                            defaultValue="100"
                                                            onBlur={(elem) => {
                                                                getAvailableCapacity(elem.target.value, item, "availability");
                                                                getAvailability(elem.target.value, "availability")
                                                            }}
                                                        />
                                                    </td>

                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}