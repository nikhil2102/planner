import React from 'react';

export default class Sprint extends React.Component {

    render() {
        const { activeSprint, getMaxCapacity, teamSize } = this.props;

        return (
            <div className="col-lg-4">
                <div className="card">
                    <div className="card-header header-height">
                        <h4 className="text-primary"><i className="tim-icons icon-light-3 padding-right"></i>Sprint Details</h4>
                        <div className="card-title">

                            <div className="row">
                                <div className="col-lg-6">
                                    <p className="bold margin-bottom">Current Sprint : </p>
                                    <p className="bold margin-bottom">Start Date : </p>
                                    <p className="bold margin-bottom">End Date : </p>
                                </div>
                                <div className="col-lg-6">
                                    <p className="margin-bottom">{activeSprint[0]?.sprint?.name}</p>
                                    <p className="margin-bottom">{activeSprint[0]?.sprint?.startDate}</p>
                                    <p className="margin-bottom">{activeSprint[0]?.sprint?.endDate}</p>
                                </div>
                            </div>

                            <div className="row">
                                <div className="col-lg-6">
                                    <p className="bold margin-bottom"><span className="bold">Number of Days in Sprint: </span></p>
                                </div>
                                <div className="col-lg-6">
                                    <p>
                                        <input id={"daysInSprint"} className="form-control valid" type="number" name="days" min="0" max="15" aria-invalid="false" defaultValue="11" onBlur={(elem) => getMaxCapacity(teamSize, elem.target.value, document.getElementById("hoursPerDay").value)} onKeyDown={(event) => event.preventDefault()}/>
                                    </p>
                                </div>
                            </div>

                            <div className="row">
                                <div className="col-lg-6">
                                    <p className="bold margin-bottom"><span className="bold">Hours per Day: </span></p>
                                </div>
                                <div className="col-lg-6">
                                    <p>
                                        <input id={"hoursPerDay"} className="form-control valid" type="number" name="hours" min="0" max="9" aria-invalid="false" defaultValue="6" onBlur={(elem) => getMaxCapacity(teamSize, document.getElementById("daysInSprint").value, elem.target.value)} onKeyDown={(event) => event.preventDefault()}/>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div >
        )
    }
}