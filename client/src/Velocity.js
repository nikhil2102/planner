import React from 'react';

export default class Velocity extends React.Component {

    render() {
        const { forcastedStoryPoints } = this.props;

        return (
            <div className="col-lg-4">
                <div className="card">
                    <div className="card-header header-height">
                        <h4 className="text-success"><i className="tim-icons icon-spaceship padding-right"></i>Velocity Details</h4>
                        <div className="card-title">
                            <div className="text-align-center">
                                <p className="font-15">Story Points forecasted for current sprint</p>
                                <p className="font-60 bold text-success">{forcastedStoryPoints}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}