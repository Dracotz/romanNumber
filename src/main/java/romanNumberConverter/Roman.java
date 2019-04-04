package romannumberconverter;

public class Roman {
  public int convert(String romanNumber) {
    int result = 0;
    int groupement = 0;
    char avant = 'w';
  	for(int i=0; i<romanNumber.length(); i++) {
  		char lettre = romanNumber.charAt(i);

      if(lettre == avant) {
        groupement++;
      } else {
        groupement = 0;
      }
      if(groupement >= 3) {
        throw new IllegalArgumentException("syntaxe non valide");
      }
      avant = lettre;

      if(i < romanNumber.length()-1) {
        char apres = romanNumber.charAt(i+1);
        if(convertUnique(lettre) < convertUnique(apres)) {
          if(groupement != 0) {
            throw new IllegalArgumentException("syntaxe non valide");
          }
          result -= convertUnique(lettre);
        } else {
          result += convertUnique(lettre);
        }
      } else {
        result += convertUnique(lettre);
      }

  	}
    return result;
  }

  public int convertUnique(char c) {
    switch (c) {
      case 'I':  return 1;
      case 'V':  return 5;
      case 'X':  return 10;
      case 'L':  return 50;
      case 'C':  return 100;
      case 'D':  return 500;
      case 'M':  return 1000;
      default: throw new IllegalArgumentException("entree non reconnue");
    }
  }

  public boolean checkOrdreDecroissant(String nombre) {
    return false;
  }

	public String convert(int number) {
    String result = "";
    switch (number) {
      case 1:  result = "I";
       break;
      case 5:  result = "V";
       break;
      case 10:  result = "X";
       break;
      case 50:  result = "L";
        break;
      case 100:  result = "C";
        break;
      case 500:  result = "D";
        break;
      case 1000:  result = "M";
        break;
      default: throw new IllegalArgumentException("nombre non reconnu");
    }
    return result;
	}
}
