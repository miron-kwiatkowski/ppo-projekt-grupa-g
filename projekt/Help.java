public class Help {

    public Help help(String x) {
        switch (x) {
            case "":
                System.out.println("Aby uzyskać informacje o broni wpisz "b". Jeśli jednak interesują cię napoje alkoholowe i zakąski, to wpisz "ia" ");
                // Print help information
                break;
            case "b":
                System.out.println("Lista przedmiotów, które możesz zdobyć w trakcie rozgrywki:");
                System.out.println("Batonik - Tani i w miarę pożywny. Ponosi poziom cukru. + 5 hp");
                System.out.println("Pizza - Kawałek starej pizzy znaleziony przy śmietniku. Szkoda, że hawajska... + 20 hp");
                System.out.println("Mortadela - Ulubiona szynka, która nie widziała mięsa w składzie. + 15 hp");
                System.out.println("Bułka - Kajzerka z ulubionego dyskontu. 33 grosze, a tyle smaku. Idealna do mortadeli. + 10 hp");
                System.out.println("Amarenka - Mirabelkowa Amarenka. Nic dodać, nic ująć. Pyszny smak, a jak sponiewiera! + 15 mp");
                System.out.println("Winko - Najtańszy winiacz jaki tylko można było znaleźć. Nie dość mocny, aby upić się po butelce. + 5 mp");
                System.out.println("Piwko - Jedyne słuszne - Mocny VIP za całe 1,99! Można się nayebać za dobre pieniądze. + 10 mp");
                System.out.println("Wódeczka - Królowa wśród tanich alkoholi. Nie ważne czy to małpeczka czy półlitrówka, jej cudowna moc zawsze zostanie doceniona. + 20 mp");
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
                System.out.println("Błąd xD Nie umiesz pisać");
        }
        return this;
    }
}
