import React from 'react';
import Content from './Content.js';

export default class App extends React.Component {

    render() {

        const baseURL = "http://10.131.35.209:8090";

        return (
            <>
                <div className="main-panel">
                    <div className="top-title">Velocity Forcast</div>
                    <div className="content">
                        <Content baseURL={baseURL} />
                    </div>
                </div>
            </>
        )
    }
}