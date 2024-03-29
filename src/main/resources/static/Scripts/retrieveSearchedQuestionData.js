
 async function getQuestions() {
   const queryString = window.location.search;
   const urlParams = new URLSearchParams(queryString);
   const urlString = 'http://localhost:8080/questions/byTitle/' + urlParams.get('searchBar');
   try {
     const response = await fetch(
       urlString,
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

 getQuestions().then(data => {
   console.log(data);

   const dl = document.createElement('dl');
   dl.classList.add("container");

   data.forEach(question => {
     const dlTag = document.createElement('dl');
     dlTag.classList.add("card");

     const dt = document.createElement('dt');
     dt.classList.add("container");

     const anchor = document.createElement('a');
     anchor.href = 'questionPage.html?id=' + question.questionId;
     anchor.innerHTML = question.title;
     dt.appendChild(anchor);

     dt.style.fontSize = '22px';

     const dd = document.createElement('dd');

     const content = document.createElement('dd');
     content.innerHTML = `Date posted: ${question.datePosted}`;

     const author = document.createElement('dd');
     author.innerHTML = `Author: ${question.accountName}`;

     dd.append(...[content, author]);

     dt.appendChild(dd);
     dlTag.appendChild(dt);

     dl.appendChild(dlTag);
   });

   const container = document.getElementById('container');
   container.appendChild(dl);
 });
