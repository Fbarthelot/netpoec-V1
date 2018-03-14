var films= [];
var film6= [];
var i=0;

$.ajax({
    url:"http://moviesdb.brm.us/api/movies",
    crossdomain:true,
    dataType:"jsonp"

}).done(function(response){
    films=response.content.movies;
    if(!films.length){
    console.log("no surch have been found");
    }

readFilm();
      i=i+6;
}).fail(function(){
console.log(" an error has occured ...")
});

//$( document ).ready(function() {
    $("#btn-film").on('click',function(){
    readFilm();
      i=i+6;

    });
//});

function readFilm(){
film6=films.slice((0+i),(6+i));
   $.each(film6,function(index, value){

      var $title='<h3>'+value.title+'</h3>';
      var $img='<img src="'+value.cover_small+'"/>';
      var $description='<p>'+value.description+'</p>'
//      $('.films').append(`<div class="filmImg pull-left">${$img}${$title}${value.description}</div>`);
      $('.films').append('<div class="col-xs-6 col-md-4"><div class="thumbnail"><a href="#" class="modal-image" type="button" data-toggle="modal" data-target=".bs-example-modal-sm">'+$img+'</a> <div class="caption">'+$title+'</div> </div></div>');
   });
};