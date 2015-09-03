blip.sampleLoader()
    .samples({
    'snare': './snare.wav',
	'hihat': './pedalhihat.wav',
	'kick' : './kick.wav'
})
    .done(loaded)
    .load();
var TEMPO = 80;
function loaded() {
    var pedalHat = blip.clip()
        .sample('hihat');

    var hihatGroove = blip.loop()
        .tempo(TEMPO)
        .data([1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0])
        .tick(function (t, d) {
		if(d){
        pedalHat.play(t);
		}
    })
	
	 var snare = blip.clip()
        .sample('snare');

    var snareGroove = blip.loop()
        .tempo(TEMPO)
        .data([0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0])
        .tick(function (t, d) {
		if(d){
        snare.play(t);
		}
    })
	
	var kick = blip.clip()
        .sample('kick');

    var kickGroove = blip.loop()
        .tempo(TEMPO)
        .data([1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0])
        .tick(function (t, d) {
		if(d){
        kick.play(t);
		}
    })



        hihatGroove.start();
		snareGroove.start();
		kickGroove.start();
  
}