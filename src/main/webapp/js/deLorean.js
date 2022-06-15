(function(global){
    var DeloreanLoader = function(selector,numberSpan){
        var _ = this; // avoid scoping issues
        numberSpan = numberSpan || '.number'; // container where number changes
        _.loader  = document.querySelector(selector); // loader dom
        _.counter = 0;
        _.counterContainer = _.loader.querySelector(numberSpan);

        _.randNum = function (min,max){ //make random bumbers
            return Math.round(Math.random()*(max-min))+min;
        }

        _.progress = function(addToCount,callback,container){ //takes counter value and poots it in the counter container
            _.counter = (_.counter + addToCount < 100 ) ? (_.counter + addToCount) : 100; // must never be more than one hundred because wew
            _.counterContainer.innerText = _.counter; //poot
            callback && callback(); // run callback if it exists
        };

        _.cycle = function(){
            var addToCount = _.randNum(1,30), //number to add to counter
                toInterval = _.counter == 0 ? 750 : _.randNum(10,500), //750 is the time mark after the set $loader-enter-duration. change if u change that css var too so the timing is nice
                callback;
            if(_.counter < 100 && (_.counter + addToCount) < 100) {  // must never be more than one hundred because wew
                addToCount = addToCount,
                callback = _.cycle;
            }else{
                _.counter = 100;
            }
            
            setTimeout(function(){
                _.progress( addToCount, callback, _.counterContainer ); //display progress
            },toInterval);
        };

        _.killLoader = function(){ //duh. called when shit ready. checks every millisecond after dom is ready that loader is ready too.
            var killerInterval = setTimeout(function(){ 
                if(_.counter == 100)  { //
                    console.log('Ready');
                    document.querySelector('html').classList.add('loaded');
                    clearTimeout(killerInterval);
                }else{
                    _.killLoader() 
                };
            },100);
        }

        document.addEventListener("DOMContentLoaded", function() {
            _.killLoader();
        });

        _.cycle();
        return _;
    }
    window.DeloreanLoader = DeloreanLoader;
})(window);

// init
DeloreanLoader('#loader','.number');