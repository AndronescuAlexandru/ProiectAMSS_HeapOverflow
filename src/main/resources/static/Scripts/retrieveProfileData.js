async function getProfile() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    try {
        const response = await fetch(
          'http://localhost:8080/profile/user',
          {
            method: 'GET',
          },
        );
    
        if (!response.ok) {
          throw new Error(`Error! status: ${response.status}`);
        }
    
        const data = await response.json();
    
        return data;
    } catch (error) {
        console.log(error);
    }
}

getProfile().then(data => {
    console.log(data);

    document.getElementById('account-name').innerText = data.accountName;
    document.getElementById('description').innerText = data.description;
    document.getElementById('email').innerText = data.email;
    document.getElementById('email-verified').innerText = data.emailVerified ? 'Yes' : 'No';
    document.getElementById('engagement-score').innerText = data.engagementScore;
    document.getElementById('highest-achieved-badge').innerText = data.highestAchievedBadge;
});

function changeDescription() {
    const queryString = window.location.search;
    const input = document.getElementById('addDescriptionContent').value;
    const urlString = 'http://localhost:8080/profile/description/' + input;
    try {
        const data = fetch(
          urlString,
          {
            method: 'POST',
          },
        );

        console.log(data);

        document.getElementById('description').innerText = input;
      } catch (error) {
        console.log(error);
      }
    return false;
}