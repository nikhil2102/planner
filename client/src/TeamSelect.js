import React from 'react';
import Message from './Message.js';

export default class TeamSelect extends React.Component {

    render() {
        const { teamNames, getTeamDetails, placeHolderValue } = this.props;

        return (
            (teamNames && teamNames.length > 0) ?
                <div className="row">
                    <div className="col-12">
                        <div className="card">
                            <div className="card-body">
                                <div className="row">
                                    <div className="col-md-12">
                                        <h4 className="card-title">Select Your Team</h4>
                                        <div className="row">
                                            <div className="col-lg-12 col-md-12 col-sm-12">
                                                <div className="dropdown bootstrap-select" style={{ "width": "100%" }}>
                                                    <button type="button" className="btn dropdown-toggle select-with-transition bs-placeholder" data-toggle="dropdown" role="button" title={placeHolderValue} aria-expanded="false">
                                                        <div className="filter-option">
                                                            <div className="filter-option-inner">
                                                                <div className="filter-option-inner-inner">{placeHolderValue}</div>
                                                            </div>
                                                        </div>
                                                    </button>
                                                    <div className="dropdown-menu" style={{ "maxHeight": "300px", "overflowY": "auto" }}>
                                                        < div className="inner show">
                                                            <ul className="dropdown-menu inner show">
                                                                <li className="disabled">
                                                                    <a role="option" className="dropdown-item disabled" tabIndex="-1">
                                                                        <span className="text">Choose Team</span>
                                                                    </a>
                                                                </li>
                                                                {teamNames.map((value, index) => {
                                                                    return (
                                                                        <li key={index} onClick={() => getTeamDetails(value)}>
                                                                            <a role="option" className="dropdown-item" tabIndex="0">
                                                                                <span className="bold">
                                                                                    {value.name}
                                                                                </span>
                                                                                {value.lead && " - " + value.lead}
                                                                            </a>
                                                                        </li>
                                                                    )
                                                                })}
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div >
                </div >
                :
                (teamNames && teamNames.error) ?
                    <Message msg={teamNames.error.message} />
                    :
                    <></>
        )
    }
}