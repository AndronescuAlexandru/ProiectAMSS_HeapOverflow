function addComment(){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const urlString = 'http://localhost:8080/questions/addComment/' + urlParams.get('id') + '/' + document.getElementById('addCommentContent').value;
    try {
        const response = await fetch(
          urlString,
          {
            method: 'POST',
          },
        );
      } catch (error) {
        console.log(error);
      }
}