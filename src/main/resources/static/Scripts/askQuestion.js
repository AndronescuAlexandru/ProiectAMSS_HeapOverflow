function postQuestion(){
       let generatedId = Math.floor((Math.random() * 1000000) + 1);
       const urlString = 'http://localhost:8080/questions/new/' + generatedId + '/' + document.getElementById('questionTitle').value + '/' + document.getElementById('questionContent').value;
       try {
           const response = fetch(
             urlString,
             {
               method: 'POST',
             },
           );
         } catch (error) {
           console.log(error);
         }
       window.location = 'http://localhost:8080/questionPage.html?id=' + generatedId;
}