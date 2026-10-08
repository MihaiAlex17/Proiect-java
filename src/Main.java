import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        FoodDeliveryService service = new FoodDeliveryService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Localuri local1 = new Localuri(1, "Pizza Hut", "Pizza", 4.5, "Splaiul Independenței 210B");
        Localuri local2 = new Localuri(2, "Burger King", "Burgeri", 4.0, "Calea Victoriei 155");
        Localuri local3 = new Localuri(3, "Shaormeria WOW", "Shaorma", 5.0, "Splaiul Independenței 290" );
        Localuri local4 = new Localuri(4, "Shaormeria C&A", "Shaorma", 4.3, "Bulevardul Uverturii 102" );
        Localuri local5 = new Localuri(5, "McDonalds", "Burgeri", 4.1,"Strada Dr. Iacob Felix 8");

        local1.adaugaProdus(new Produs("Pizza Margherita", 25.0, "Pizza", 400));
        local1.adaugaProdus(new Produs("Pizza Quattro Stagioni", 32.0, "Pizza", 450));
        local1.adaugaProdus(new Produs("Pizza Diavola", 29.5, "Pizza", 420));
        local1.adaugaProdus(new Produs("Pizza Vegetariana", 27.0, "Pizza", 410));
        local1.adaugaProdus(new Produs("Pizza Prosciutto", 30.0, "Pizza", 430));

        local2.adaugaProdus(new Produs("Whopper", 22.0, "Burger", 300));
        local2.adaugaProdus(new Produs("Chicken Burger", 19.0, "Burger", 280));
        local2.adaugaProdus(new Produs("Double Cheeseburger", 24.5, "Burger", 320));
        local2.adaugaProdus(new Produs("Onion Rings", 8.5, "Snack", 150));
        local2.adaugaProdus(new Produs("Milkshake", 11.0, "Bautura", 250));

        local3.adaugaProdus(new Produs("Shaorma Mare Pui", 22.5, "Shaorma", 450));
        local3.adaugaProdus(new Produs("Shaorma Vita", 26.0, "Shaorma", 470));
        local3.adaugaProdus(new Produs("Cartofi cu Sos", 9.0, "Garnitura", 200));
        local3.adaugaProdus(new Produs("Aripioare Picante", 18.0, "Snack", 300));
        local3.adaugaProdus(new Produs("Salată de Varza", 5.0, "Salata", 150));

        local4.adaugaProdus(new Produs("Shaorma Pui Lipie", 20.0, "Shaorma", 430));
        local4.adaugaProdus(new Produs("Shaorma Vita Lipie", 25.0, "Shaorma", 450));
        local4.adaugaProdus(new Produs("Meniu Shaorma", 30.0, "Meniu", 550));
        local4.adaugaProdus(new Produs("Cartofi Simpli", 7.5, "Garnitura", 180));
        local4.adaugaProdus(new Produs("Fanta Portocale", 6.0, "Bautura", 500));

        local5.adaugaProdus(new Produs("Big Mac", 21.0, "Burger", 320));
        local5.adaugaProdus(new Produs("McChicken", 19.0, "Burger", 300));
        local5.adaugaProdus(new Produs("Cartofi Medii", 8.5, "Garnitura", 200));
        local5.adaugaProdus(new Produs("Sundae Ciocolata", 7.0, "Desert", 250));
        local5.adaugaProdus(new Produs("Coca Cola 0.5L", 6.5, "Bautura", 500));

        service.adaugaLocal(local1);
        service.adaugaLocal(local2);
        service.adaugaLocal(local3);
        service.adaugaLocal(local4);
        service.adaugaLocal(local5);

        Client client1 = new Client(1, "Florea Mihai Alexandru", "florea@gmail.com", "Splaiul Independentei 202");
        Client client2 = new Client(2, "Mititelu Vlad", "mititelu@gmail.com", "Splaiul Independentei 203");
        Client client3 = new Client(3, "Vicol Mihnea", "vicol@gmail.com", "Splaiul Independentei 204");
        Client client4 = new Client(4, "Diaconu Andu", "diaconu@gmail.com", "Splaiul Independentei 205");
        Client client5 = new Client(5, "Cotiga David", "cotiga@gmail.com", "Splaiul Independentei 206");

        service.adaugaClient(client1);
        service.adaugaClient(client2);
        service.adaugaClient(client3);
        service.adaugaClient(client4);
        service.adaugaClient(client5);

        Curier curier1 = new Curier(1, "Constantin George", "george@email.com", "Motocicleta");
        Curier curier2 = new Curier(2, "Copilau Andrei", "andrei@email.com", "Masina");
        Curier curier3 = new Curier(2, "Cotiga Mihnea", "mihnea@email.com", "Bicicleta");

        service.adaugaCurier(curier1);
        service.adaugaCurier(curier2);
        service.adaugaCurier(curier3);

        while (running) {
            System.out.println("\n===== MENIU PRINCIPAL =====");
            System.out.println("1. Inregistreaza client nou");
            System.out.println("2. Afiseaza localuri");
            System.out.println("3. Afiseaza top 3 localuri");
            System.out.println("4. Plaseaza comanda");
            System.out.println("5. Afiseaza istoricul unui client");
            System.out.println("6. Afiseaza recenziile unui local");
            System.out.println("7. Adauga recenzie la un local");
            System.out.println("8. Afiseaza produse sub un pret dat");
            System.out.println("9. Adauga recenzie la un curier");
            System.out.println("10. Afiseaza recenziile unui curier");
            System.out.println("11. Meniu CRUD");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");
            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    service.inregistrareClient();
                    AuditService.getInstance().logAction("Inregistrare client");
                    break;
                case 2:
                    service.afiseazaLocaluri();
                    AuditService.getInstance().logAction("Afisare localuri");
                    break;
                case 3:
                    service.afiseazaTopLocaluri();
                    AuditService.getInstance().logAction("Afisare top localuri");
                    break;
                case 4:
                    service.plaseazaComanda();
                    AuditService.getInstance().logAction("Plasare comanda");
                    break;
                case 5:
                    service.afiseazaIstoricClient();
                    AuditService.getInstance().logAction("Afisare istoric client");
                    break;
                case 6:
                    service.afiseazaRecenziileLocalului();
                    AuditService.getInstance().logAction("Afisare recenzii local");
                    break;
                case 7:
                    service.adaugaRecenzieLaLocal();
                    AuditService.getInstance().logAction("Adaugare recenzie local");
                    break;
                case 8:
                    service.afiseazaProduseSubPret();
                    AuditService.getInstance().logAction("Afisare produse sub pret");
                    break;
                case 9:
                    service.adaugaRecenzieCurier();
                    AuditService.getInstance().logAction("Adaugare recenzie curier");
                    break;
                case 10:
                    service.afiseazaRecenziileCurierului();
                    AuditService.getInstance().logAction("Afisare recenzii curier");
                    break;
                case 0:
                    running = false;
                    System.out.println("La revedere!");
                    break;
                case 11:
                    boolean runningCrud = true;
                    while (runningCrud) {
                        System.out.println("\n===== MENIU CRUD =====");
                        System.out.println("1. Adauga Client");
                        System.out.println("2. Afiseaza Clienti");
                        System.out.println("3. Modifica Client");
                        System.out.println("4. Sterge Client");

                        System.out.println("5. Adauga Local");
                        System.out.println("6. Afiseaza Localuri");
                        System.out.println("7. Modifica Local");
                        System.out.println("8. Sterge Local");

                        System.out.println("9. Adauga Produs");
                        System.out.println("10. Afiseaza Produse");
                        System.out.println("11. Modifica Produs");
                        System.out.println("12. Sterge Produs");

                        System.out.println("13. Adauga Curier");
                        System.out.println("14. Afiseaza Curieri");
                        System.out.println("15. Modifica Curier");
                        System.out.println("16. Sterge Curier");

                        System.out.println("0. Revenire la meniul principal");

                        System.out.print("Alege optiunea CRUD: ");
                        int optCrud = scanner.nextInt();
                        scanner.nextLine();

                        switch (optCrud) {
                            case 1:
                                System.out.print("Nume client: ");
                                String numeClient = scanner.nextLine();
                                System.out.print("Email client: ");
                                String emailClient = scanner.nextLine();
                                System.out.print("Adresa client: ");
                                String adresaClient = scanner.nextLine();
                                Client newClient = new Client(0, numeClient, emailClient, adresaClient);
                                ClientDAO.getInstance().create(newClient);
                                System.out.println("Client adaugat!");
                                break;
                            case 2:
                                for (Client c : ClientDAO.getInstance().readAll()) {
                                    System.out.println(c);
                                }
                                break;
                            case 3:
                                System.out.print("ID client de modificat: ");
                                int idClientMod = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nume nou: ");
                                String numeNou = scanner.nextLine();
                                System.out.print("Email nou: ");
                                String emailNou = scanner.nextLine();
                                System.out.print("Adresa noua: ");
                                String adresaNoua = scanner.nextLine();
                                Client clientMod = new Client(idClientMod, numeNou, emailNou, adresaNoua);
                                ClientDAO.getInstance().update(clientMod);
                                System.out.println("Client modificat!");
                                break;
                            case 4:
                                System.out.print("ID client de sters: ");
                                int idClientDel = scanner.nextInt();
                                ClientDAO.getInstance().delete(idClientDel);
                                System.out.println("Client sters!");
                                break;

                            case 5:
                                System.out.print("Nume local: ");
                                String numeLocal = scanner.nextLine();
                                System.out.print("Tip local: ");
                                String tipLocal = scanner.nextLine();
                                System.out.print("Rating local: ");
                                double ratingLocal = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Adresa local: ");
                                String adresaLocal = scanner.nextLine();
                                Localuri newLocal = new Localuri(0, numeLocal, tipLocal, ratingLocal, adresaLocal);
                                LocaluriDAO.getInstance().create(newLocal);
                                System.out.println("Local adaugat!");
                                break;
                            case 6:
                                for (Localuri l : LocaluriDAO.getInstance().readAll()) {
                                    System.out.println(l);
                                }
                                break;
                            case 7:
                                System.out.print("ID local de modificat: ");
                                int idLocalMod = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nume nou: ");
                                String numeLocalNou = scanner.nextLine();
                                System.out.print("Tip nou: ");
                                String tipNou = scanner.nextLine();
                                System.out.print("Rating nou: ");
                                double ratingNou = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Adresa noua: ");
                                String adresaNouaLocal = scanner.nextLine();
                                Localuri localMod = new Localuri(idLocalMod, numeLocalNou, tipNou, ratingNou, adresaNouaLocal);
                                LocaluriDAO.getInstance().update(localMod);
                                System.out.println("Local modificat!");
                                break;
                            case 8:
                                System.out.print("ID local de sters: ");
                                int idLocalDel = scanner.nextInt();
                                LocaluriDAO.getInstance().delete(idLocalDel);
                                System.out.println("Local sters!");
                                break;

                            case 9:
                                System.out.print("Nume produs: ");
                                String numeProdus = scanner.nextLine();
                                System.out.print("Pret produs: ");
                                double pretProdus = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Categorie produs: ");
                                String categorieProdus = scanner.nextLine();
                                System.out.print("Gramaj produs: ");
                                int gramajProdus = scanner.nextInt();
                                System.out.print("ID local pentru produs: ");
                                int idLocalProdus = scanner.nextInt();
                                scanner.nextLine();
                                Produs newProdus = new Produs(numeProdus, pretProdus, categorieProdus, gramajProdus);
                                ProdusDAO.getInstance().create(newProdus, idLocalProdus);
                                System.out.println("Produs adaugat!");
                                break;
                            case 10:
                                for (Produs p : ProdusDAO.getInstance().readAll()) {
                                    System.out.println(p);
                                }
                                break;
                            case 11:
                                System.out.print("ID produs de modificat: ");
                                int idProdusMod = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nume nou: ");
                                String numeProdNou = scanner.nextLine();
                                System.out.print("Pret nou: ");
                                double pretNou = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Categorie noua: ");
                                String categorieNoua = scanner.nextLine();
                                System.out.print("Gramaj nou: ");
                                int gramajNou = scanner.nextInt();
                                scanner.nextLine();
                                Produs produsMod = new Produs(numeProdNou, pretNou, categorieNoua, gramajNou);
                                ProdusDAO.getInstance().update(idProdusMod, produsMod);
                                System.out.println("Produs modificat!");
                                break;
                            case 12:
                                System.out.print("ID produs de sters: ");
                                int idProdusDel = scanner.nextInt();
                                ProdusDAO.getInstance().delete(idProdusDel);
                                System.out.println("Produs sters!");
                                break;

                            case 13:
                                System.out.print("ID curier: ");
                                int idCurier = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nume curier: ");
                                String numeCurier = scanner.nextLine();
                                System.out.print("Email curier: ");
                                String emailCurier = scanner.nextLine();
                                System.out.print("Vehicul curier: ");
                                String vehiculCurier = scanner.nextLine();
                                Curier newCurier = new Curier(idCurier, numeCurier, emailCurier, vehiculCurier);
                                CurierDAO.getInstance().create(newCurier);
                                System.out.println("Curier adaugat!");
                                break;
                            case 14:
                                for (Curier cu : CurierDAO.getInstance().readAll()) {
                                    System.out.println(cu);
                                }
                                break;
                            case 15:
                                System.out.print("ID curier de modificat: ");
                                int idCurierMod = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nume nou: ");
                                String numeCurierNou = scanner.nextLine();
                                System.out.print("Email nou: ");
                                String emailCurierNou = scanner.nextLine();
                                System.out.print("Vehicul nou: ");
                                String vehiculNou = scanner.nextLine();
                                Curier curierMod = new Curier(idCurierMod, numeCurierNou, emailCurierNou, vehiculNou);
                                CurierDAO.getInstance().update(curierMod);
                                System.out.println("Curier modificat!");
                                break;
                            case 16:
                                System.out.print("ID curier de sters: ");
                                int idCurierDel = scanner.nextInt();
                                CurierDAO.getInstance().delete(idCurierDel);
                                System.out.println("Curier sters!");
                                break;

                            case 0:
                                runningCrud = false;
                                break;

                            default:
                                System.out.println("Optiune CRUD invalida!");
                        }
                    }
                    break;

                default:
                    System.out.println("Optiune invalida, incearca din nou!");
            }
        }
    }

}

