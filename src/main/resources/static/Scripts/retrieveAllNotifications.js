async function getNotifications() {
  try {
    const response = await fetch(
      'http://localhost:8080/notifications/list',
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

getNotifications().then(data => {
  console.log(data);

  const dl = document.createElement('dl');
  dl.classList.add("container");

  data.forEach(notification => {
      const dlTag = document.createElement('dl');
      dlTag.classList.add("card");

      const dt = document.createElement('dt');
      dt.classList.add("container");

      const anchor = document.createElement('a');
      anchor.href = 'questionPage.html?id=' + notification.id_question;
      anchor.innerHTML = 'You have a new notification!';
      dt.appendChild(anchor);



      dlTag.appendChild(dt);

      dl.appendChild(dlTag);
  });

  const container = document.getElementById('container');
  container.appendChild(dl);
});
