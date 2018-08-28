package overloadingdemor;

public class MethodOverLoading {

	public static void main(String[] args) {
		MusicalInstrument drum 	= new Drum();
		Guitar guitar 		 	= new Guitar();
		Player player 			= new Player();
		player.playInstrument(drum);
		player.playInstrument(guitar);
	}
}

abstract class MusicalInstrument{
}

class Drum extends MusicalInstrument{
}


class Guitar extends MusicalInstrument{
}

class Player{
	public void playInstrument(Drum drum){
		System.out.println("TamTam");
	}
	
	public void playInstrument(Guitar guitar){
		System.out.println("MiFa");
	}
	
	public void playInstrument(MusicalInstrument instrument){
		System.out.println("Any sound");
	}
}
