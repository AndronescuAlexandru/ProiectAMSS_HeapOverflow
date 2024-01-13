async function getQuestions() {
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  try {
    const response = await fetch(
      'http://localhost:8080/questions/byId/' + urlParams.get('id'),
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
  const title = document.createElement('h2');
  const content = document.createElement('p');

  const divCommentTag = document.createElement('div');

  data.forEach(question => {
    title.innerHTML = question.title;

    const commentContainer = document.getElementById('commentContainer');
    const container = document.getElementById('questionContainer');

    const dateTimePosted = document.createElement('dt');
    dateTimePosted.innerHTML = `Date posted: ${question.datePosted}`;

    const author = document.createElement('dt');
    author.innerHTML = `Author: ${question.accountName}`;

    content.innerHTML = question.content;

    dl.append(...[dateTimePosted, author]);

    container.appendChild(title);
    container.appendChild(dl);
    container.appendChild(content);

    question.commentList.forEach(comment =>{
        const dlCommentTag = document.createElement('dl');
        const commentDateTimePosted = document.createElement('dt');
        commentDateTimePosted.innerHTML = `Date posted: ${comment.datePosted}`;

        const commentAuthor = document.createElement('dt');
        commentAuthor.innerHTML = `Author: ${comment.accountName}`;

        dlCommentTag.append(...[commentDateTimePosted, commentAuthor]);

        const commentContent = document.createElement('p');
        commentContent.innerHTML = comment.content;

        const lineBreak = document.createElement('br');

        divCommentTag.appendChild(dlCommentTag);
        divCommentTag.appendChild(commentContent);

        commentContainer.appendChild(divCommentTag);
        commentContent.appendChild(lineBreak);
    })

  });
});
