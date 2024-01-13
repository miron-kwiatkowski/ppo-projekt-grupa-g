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
                System.out.println("Klejpała - Wyjęta ze śmietnika, potężna laska kleju na gorąco. Idealna do pałowania przeciwników. + 5 do ataku");
                System.out.println("Tulipan - Rozbita o krawężnik pusta butelka po tanim winku. Broń krucha, ale jakże skuteczna. + 10 do ataku");
                System.out.println("Bombelek - Amunicja wielokrotnego użytku - rzucasz, a po trafieniu w przeciwnika bachorek wraca. + 15 do ataku");
                System.out.println("Kij - Nie stać cię na prawdziwy kij bejsbolowy? Nic starconego! Kij od mitły zadziała równie skutecznie. + 10 do ataku");
                System.out.println("Strzykawka - Lepiej na nią uważać. Nie wiadomo ile osób korzystało z niej wcześniej. Roznosi HIV. + 15 do ataku");
                break;
            default:
                System.out.println("błąd xd");
        }
        return this;
    }
}
