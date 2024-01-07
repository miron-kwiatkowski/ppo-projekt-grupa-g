public class Activities {

    public void attack() {
        System.out.println("Atak");
        //atak zwykły postaci;
    }

    public void specialAttack() {
        System.out.println("Specjalny Atak");
        //sprawdż klase, użyj atak specjalny (np attack + dodatkowe staty);

    }

    public Activities itemsUse(String x) { //atakujące
        switch (x) {
            case "klejpała":
                //sprawdż czy posiada, jeśli tak użyj;
                System.out.println("Gracz używa klejpały!");
                //info o obrażeniach
                break;
            case "tulipan":
                //sprawdż czy posiada, jeśli tak użyj;
                System.out.println("Gracz używa tulipana");
                //info o obrażeniach
                break;
            case "bombelek":
                //sprawdż czy posiada, jeśli tak użyj;
                System.out.println("Gracz używa bombelka");
                //info o obrażeniach
                break;
            default:
                System.out.println("Nie dla psa!");
                //nie ma przedmiotu błąd;
        }
        return this;
    }

    public Activities itemsBusts(String x) { // dodające hp i mane

        switch (x) {
            case "Batonik":
                //sprawdż czy posiada, jeśli tak użyj;
                System.out.println("Dobry mars byku");
                //info o dodanych statach
                break;
            case "Amarenka":
                //sprawdż czy posiada, jeśli tak użyj;
                System.out.println("MMM dobry rocznik");
                //info o dodanych statach
                break;
            default:
                System.out.println("Nie dla psa!");
                //nie ma przedmiotu błąd;
        }
        return this;}

        public Activities help(String x) {
            switch (x) {
                case "":
                    System.out.println("Oto co możesz począć:" +
                            "\n-zaatakować z kopa lub bara (a)" +
                            "\n-uzyć ataku specjalnego (spa), ale czy masz na to siłę?" +
                            "\n-użyj broni, nie bądż pizda! (ia)" +
                            "\n-zregeneruj siły (b)");
                    System.out.println("Chcesz dowiedzieć się więcej? Wpisz help ia/b (broń/przedmiot)");
                    break;
                case "b":
                    System.out.println("Tu jest lista buffów do użytku xd");
                    break;
                case "ia":
                    System.out.println("tu jest lista broni do użytku");
                    break;
                default:
                    System.out.println("błąd xd");
            }
            return null;
        }
    }


