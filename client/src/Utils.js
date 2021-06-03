export function buildAvailableCapacityPostData(value, teamMember, dataStructure, valueType) {
    // value will be boolean when checkbox in clicked and will be string for input number box

    if (typeof value === "boolean") {
        if (value) {
            // value will be true when checkbox is checked. In that case we need to remove that team member.
            const index = dataStructure.findIndex(i => i.name === teamMember.name);
            if (index > -1) { dataStructure.splice(index, 1) }

        } else {
            // value will be false when checkbox is un-checked. In that case we need to add that team member.
            dataStructure.push({
                "availability": 100,
                "absentDays": 0,
                "name": teamMember.name,
                "type": teamMember.memberships[0].role.name
            })
        }
    } else {
        dataStructure.map((item) => {
            if (item.name === teamMember.name) {
                if (valueType === "absence") {
                    item.absentDays = value
                } else if (valueType === "availability") {
                    item.availability = parseInt(value)
                }
            }
        })
    }

    return dataStructure
}

export function buildTeamData(teamDetails) {
    let data = [];

    teamDetails && Object.keys(teamDetails).length > 0 &&
        teamDetails.teamMembers && teamDetails.teamMembers.length > 0 &&
        teamDetails.teamMembers.map((item) => {
            data.push({
                "availability": 100,
                "absentDays": 0,
                "name": item.name,
                "type": item.memberships[0].role.name
            })
        })

    return data
}

export function getForcastedStoryPoints(teamSprintDetails, availableCapacity) {
    let forcastedStoryPoints, totalVelocity = 0, totalSprints = 0;
    const closedSprints = teamSprintDetails?.filter((item) => item.sprint?.state !== 'ACTIVE');

    closedSprints && closedSprints.length > 0 &&
        closedSprints.map((value, index) => {

            const capacity = value?.sprintCapacity?.capacity
            let storyPoint = 0;

            value?.contents?.completedIssues?.map((val) => {
                if (val?.estimateStatistic?.statFieldValue?.value !== undefined) {
                    storyPoint += val.estimateStatistic.statFieldValue.value
                }
            })

            totalVelocity += storyPoint / capacity;
            totalSprints = index + 1
        })

    forcastedStoryPoints = (totalVelocity / totalSprints) * availableCapacity;

    return Math.round(forcastedStoryPoints)

}

function getTotalHours(hoursPerDay, availability) {
    let totalHours;
    totalHours = hoursPerDay * (availability / 100)

    return totalHours
}

function getAvailableHours(daysInSprint, absence, totalHours) {
    let availableHours;
    availableHours = ((daysInSprint * totalHours) - (absence * totalHours));

    return availableHours
}

function getCapacity(daysInSprint, totalHours) {
    let capacity;
    capacity = (availableHours / (daysInSprint * totalHours)) * 100;

    return capacity
}

export function getCalculatedData(daysInSprint, hoursPerDay, absence, availability) {

    const totalHours = getTotalHours(hoursPerDay, availability);
    const availableHours = getAvailableHours(daysInSprint, absence, totalHours);
    const capacity = getCapacity(daysInSprint, availableHours, totalHours);

    return {
        availableHours,
        capacity
    }
}