public class Help {

    public Help help(String x) {
        switch (x) {
            case "":
                System.out.println("Oto co możesz począć:");
                // Print help information
                break;
            case "b":
                System.out.println("Tu jest lista buffów do użytku xd");
                System.out.println("Batonik - ");
                System.out.println("Amarenka - ");
                break;
            case "ia":
                System.out.println("Tu jest lista broni do użytku, jeśli je posiadasz");
                System.out.println("Klejpała - ");
                System.out.println("Tulipan - ");
                System.out.println("Bombelek - ");
                System.out.println("Laczek - ");
                System.out.println("Strzykawka - ");
                break;
            default:
                System.out.println("błąd xd");
        }
        return this;
    }
}
