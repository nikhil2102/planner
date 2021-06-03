import React from 'react';
import { HorizontalBar } from 'react-chartjs-2';

export default class Capacity extends React.Component {
    render() {
        const { maxCapacity, availableCapacity } = this.props;

        const data = (canvas) => {
            const ctx = canvas.getContext("2d")

            const gradientStrokeBlue = ctx.createLinearGradient(50, 0, 230, 0);
            gradientStrokeBlue.addColorStop(1, 'rgba(29,140,248,0.2)');
            gradientStrokeBlue.addColorStop(0.4, 'rgba(29,140,248,0.0)');
            gradientStrokeBlue.addColorStop(0, 'rgba(29,140,248,0)'); //blue colors

            const gradientStrokePurple = ctx.createLinearGradient(50, 0, 230, 0);
            gradientStrokePurple.addColorStop(1, 'rgba(208,72,182,0.2)');
            gradientStrokePurple.addColorStop(0.2, 'rgba(208,72,182,0.0)');
            gradientStrokePurple.addColorStop(0, 'rgba(208,72,182,0)'); //purple colors

            return {
                labels: ['Maximum', 'Available'],
                datasets: [{
                    label: "Capacity",
                    fill: true,
                    backgroundColor: [gradientStrokeBlue, gradientStrokePurple],
                    hoverBackgroundColor: [gradientStrokeBlue, gradientStrokePurple],
                    borderColor: ['#1f8ef1', '#d048b6'],
                    borderWidth: 2,
                    data: [maxCapacity, availableCapacity],
                }]
            }
        };

        return (
            <div className="col-lg-4">
                <div className="card card-chart">
                    <div className="card-header">
                        <h4 className="text-info"><i className="tim-icons icon-single-02 padding-right"></i> Capacity Details</h4>
                        <div className="card-title">
                            <div className="row">
                                <div className="col-lg-6 text-align-center">
                                    <p>Maximum Capacity</p>
                                    <p className="font-30 bold">{maxCapacity}</p>
                                </div>
                                <div className="col-lg-6 text-align-center">
                                    <p>Available capacity</p>
                                    <p className="font-30 bold text-info">{availableCapacity}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="card-body">
                        <div className="chart-area">
                            <HorizontalBar
                                data={data}
                                options={{
                                    maintainAspectRatio: false,
                                    responsive: true,
                                    legend: {
                                        display: false
                                    },
                                    scales: {
                                        xAxes: [{
                                            gridLines: {
                                                drawBorder: false,
                                                color: 'rgba(29,140,248,0.1)',
                                                zeroLineColor: "transparent",
                                            },
                                            ticks: {
                                                suggestedMin: 100,
                                                suggestedMax: 600,
                                                stepSize: 50,
                                                fontColor: "#9e9e9e"
                                            }
                                        }],
                                        yAxes: [{
                                            gridLines: {
                                                drawBorder: false,
                                                color: 'rgba(29,140,248,0.1)',
                                                zeroLineColor: "transparent",
                                            },
                                            ticks: {
                                                fontColor: "#9e9e9e"
                                            }
                                        }]
                                    }
                                }}
                            />
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}