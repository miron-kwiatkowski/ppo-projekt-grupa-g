public class Help {

    public Help help(String x) {
        switch (x) {
            case "":
                System.out.println("Oto co możesz począć:");
                // Print help information
                break;
            case "b":
                System.out.println("Tu jest lista buffów do użytku xd");
                // Print information about buffs
                break;
            case "ia":
                System.out.println("Tu jest lista broni do użytku");
                // Print information about weapons
                break;
            default:
                System.out.println("błąd xd");
        }
        return this;
    }
}
