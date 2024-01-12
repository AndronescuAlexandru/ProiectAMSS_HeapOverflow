function searchQuestion(){
    var searchBarContents = document.getElementById("searchBar").value;

    fetch('/question/byTitle/{questionTitle}', {
    method:'GET',
    headers: {
        'Content-Type' : 'application/json'
    },
    body: JSON.stringify({searchBarContents: searchBar })
    }).then(response => response.json())
          .then(data => {
              console.log(data);
          })
          .catch(error => {
              console.error('Error:', error);
          });
}