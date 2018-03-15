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

    $("#btn-film").click(function(e){
     e.preventDefault();
    readFilm();
      i=i+6;

    });


function readFilm(){
film6=films.slice((0+i),(6+i));
   $.each(film6,function(index, value){

      var $title='<h3 >'+value.title+'</h3>';
      var $img='<img class="img-responsive" src="'+value.cover_small+'"/>';
      var $description='<p>'+value.description+'</p>'
//      $('.films').append(`<div class="filmImg pull-left">${$img}${$title}${value.description}</div>`);
      $('.films').append('<div  class=" col-xs-6 col-md-4"><div class="film-small thumbnail"><a href="#df" class="film-small" type="button" >'+$img+'</a> <div class="caption">'+$title+'</div> </div></div>');
//   $('.films').append(' <article class=" row article pull-left film-small col-xs-6 col-md-4"><div class="article-visual pull-left col-xs-12"><a href="#" class=" ">'+$img+'</a></div><div class="article-infos pull-left col-xs-12">'+$title+'</div></article> ');
   });
};

function resizeFilm(){
 /* on initialise la hauteur en auto pour les différents changement */
    $(".film-small").css({
    "height":"auto"
    });

    /* la fonction vient prendre la hauteur max des deux élèmments et on assigne cette hauteur max à la class commune aux deux élèmments */
        var maxHeight=0;
        $(".film-small").each(function(){
            if($(this).height()>maxHeight){

                maxHeight=$(this).height();
                /*console.log(maxHeight);*/
            }
            $(".film-small").css({
                "height":(maxHeight+16)+"px"
            });
        });
};

 $(window).resize(function(){
   resizeFilm();
 }).trigger("resize");


$(window).load(function(){
resizeFilm();
});






