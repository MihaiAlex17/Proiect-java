import java.util.*;

public class FoodDeliveryService {
    private List<Client> clienti;
    private Map<Integer, Localuri> localuri;
    private List<Recenzie> recenzii;
    private Map<Integer, IstoricComenzi> istoriceComenzi;
    private List<Curier> curieri;
    private int ComandaNouaId;

    public FoodDeliveryService() {
        clienti = new ArrayList<>();
        localuri = new HashMap<>();
        recenzii = new ArrayList<>();
        istoriceComenzi = new HashMap<>();
        curieri = new ArrayList<>();
        ComandaNouaId = 1;
    }

    public void adaugaClient(Client client) {
        clienti.add(client);
        istoriceComenzi.put(client.getId(), new IstoricComenzi(client));
    }

    public void inregistrareClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numele clientului: ");
        String nume = scanner.nextLine();
        System.out.print("Introdu email-ul clientului: ");
        String email = scanner.nextLine();
        System.out.print("Introdu adresa clientului: ");
        String adresa = scanner.nextLine();

        int idNou = 1;
        for (Client c : clienti) {
            if (c.getId() >= idNou) {
                idNou = c.getId() + 1;
            }
        }

        Client clientNou = new Client(idNou, nume, email, adresa);
        adaugaClient(clientNou);
        System.out.println("Clientul a fost inregistrat cu succes!");
    }



    public Client getClientDupaNume(String nume) {
        for (Client c : clienti) {
            if (c.getNume().equals(nume)) {
                return c;
            }
        }
        return null;
    }


    public void adaugaLocal(Localuri local) {
        localuri.put(local.getId(), local);
    }

    public void afiseazaLocaluri() {
        for (Localuri l : localuri.values()) {
            System.out.println(l);
        }
    }


    public void ProduseLocal(int idLocal) {
        Localuri local = localuri.get(idLocal);
        if (local != null) {
            for (Produs p : local.getProduse()) {
                System.out.println(p);
            }
        } else {
            System.out.println("Local inexistent!");
        }
    }

    public void adaugaCurier(Curier curier) {
        curieri.add(curier);
    }

    public void plaseazaComanda() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numele clientului: ");
        String numeClient = scanner.nextLine();

        Client client = getClientDupaNume(numeClient);
        if (client == null) {
            System.out.println("Client inexistent!");
            return;
        }
        afiseazaLocaluri();
        System.out.print("Introdu ID-ul localului: ");
        int idLocal = scanner.nextInt();
        scanner.nextLine();

        Localuri local = localuri.get(idLocal);
        if (local == null) {
            System.out.println("Local inexistent!");
            return;
        }
        System.out.println("Produse disponibile:");
        ProduseLocal(idLocal);
        System.out.print("Cate produse doresti sa comanzi? ");
        int nrProduse = scanner.nextInt();
        scanner.nextLine();
        Comanda comanda = new Comanda(ComandaNouaId++, client, local);

        for (int i = 0; i < nrProduse; i++) {
            System.out.print("Introdu numele produsului " + (i + 1) + ": ");
            String numeProdus = scanner.nextLine();

            Produs produsGasit = null;
            for (Produs p : local.getProduse()) {
                if (p.getNume().equals(numeProdus)) {
                    produsGasit = p;
                    break;
                }
            }
            if (produsGasit != null) {
                comanda.adaugaProdus(produsGasit);
            } else {
                System.out.println("Produs inexistent!");
            }
        }

        System.out.println("Alege un curier disponibil:");
        for (int i = 0; i < curieri.size(); i++) {
            System.out.println((i + 1) + ". " + curieri.get(i).getNume() + " - " + curieri.get(i).getVehicul());
        }
        System.out.print("Introdu numarul curierului ales: ");
        int alegereCurier = scanner.nextInt();
        scanner.nextLine();

        if (alegereCurier >= 1 && alegereCurier <= curieri.size()) {
            Curier curierAles = curieri.get(alegereCurier - 1);
            comanda.setCurier(curierAles);
            curierAles.adaugaComandaLivrata(comanda);
            System.out.println("Comanda plasata cu succes! Curierul ales este: " + curierAles.getNume());
        } else {
            System.out.println("Alegere invalida. Comanda nu a fost plasata.");
        }
        istoriceComenzi.get(client.getId()).adaugaComanda(comanda);
        System.out.println(comanda);
    }


    public void afiseazaIstoricClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numele clientului pentru care vrei sa vezi istoricul: ");
        String numeClient = scanner.nextLine();
        Client client = getClientDupaNume(numeClient);
        if (client != null) {
            istoriceComenzi.get(client.getId()).afiseazaIstoric();
        } else {
            System.out.println("Client inexistent!");
        }
    }


    public void afiseazaRecenziileLocalului() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numele localului pentru care vrei să vezi recenziile: ");
        String numeLocal = scanner.nextLine();
        boolean gasit = false;
        for (Localuri l : localuri.values()) {
            if (l.getNume().equals(numeLocal)) {
                gasit = true;
                System.out.println("Recenzii pentru localul " + l.getNume() + ":");
                if (l.getRecenzii().isEmpty()) {
                    System.out.println("Nu exista recenzii momentan.");
                } else {
                    for (Recenzie r : l.getRecenzii()) {
                        System.out.println(r);
                    }
                }
            }
        }
        if (!gasit) {
            System.out.println("Nu s-a gasit niciun local cu acest nume.");
        }
    }

    public void adaugaRecenzieLaLocal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numele localului pentru care vrei sa adaugi o recenzie: ");
        String numeLocal = scanner.nextLine();

        Localuri localGasit = null;
        for (Localuri l : localuri.values()) {
            if (l.getNume().equals(numeLocal)) {
                localGasit = l;
                break;
            }
        }

        if (localGasit == null) {
            System.out.println("Nu s-a gasit niciun local cu acest nume.");
            return;
        }
        System.out.print("Introdu numele clientului care lasa recenzia: ");
        String numeClient = scanner.nextLine();
        Client clientGasit = getClientDupaNume(numeClient);
        if (clientGasit == null) {
            System.out.println("Nu s-a gasit niciun client cu acest nume.");
            return;
        }
        System.out.print("Scrie comentariul recenziei: ");
        String comentariu = scanner.nextLine();
        System.out.print("Da un rating (0 - 5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        Recenzie recenzieNoua = new Recenzie(clientGasit, localGasit, comentariu, rating);
        localGasit.adaugaRecenzie(recenzieNoua);
        System.out.println("Recenzie adaugata cu succes!");
    }

    public void afiseazaProduseSubPret() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu pretul maxim: ");
        double pretMaxim = scanner.nextDouble();

        for (Localuri l : localuri.values()) {
            for (Produs p : l.getProduse()) {
                if (p.getPret() < pretMaxim) {
                    System.out.println(p + " de la " + l.getNume());
                }
            }
        }
    }
    public Curier getCurierDupaNume(String nume) {
        for (Curier c : curieri) {
            if (c.getNume().equals(nume)) {
                return c;
            }
        }
        return null;
    }

    public void adaugaRecenzieCurier() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numele clientului care lasa recenzia: ");
        String numeClient = scanner.nextLine();
        Client client = getClientDupaNume(numeClient);
        if (client == null) {
            System.out.println("Client inexistent!");
            return;
        }

        System.out.print("Introdu numele curierului pentru care vrei sa adaugi o recenzie: ");
        String numeCurier = scanner.nextLine();

        Curier curier = getCurierDupaNume(numeCurier);
        if (curier == null) {
            System.out.println("Curier inexistent!");
            return;
        }

        System.out.print("Scrie comentariul recenziei: ");
        String comentariu = scanner.nextLine();
        System.out.print("Da un rating (1 - 5): ");
        double rating = scanner.nextDouble();
        RecenzieCurier recenzieCurier = new RecenzieCurier(client, curier, comentariu, rating);
        curier.adaugaRecenzie(recenzieCurier);
        System.out.println("Recenzie pentru curier adaugata cu succes!");
    }

    public void afiseazaRecenziileCurierului() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numele curierului pentru care vrei sa vezi recenziile: ");
        String numeCurier = scanner.nextLine();
        Curier curier = getCurierDupaNume(numeCurier);
        if (curier != null) {
            System.out.println("Recenziile pentru curierul " + curier.getNume() + ":");
            if (curier.getRecenzii().isEmpty()) {
                System.out.println("Nu exista recenzii pentru acest curier.");
            } else {
                for (RecenzieCurier recenzie : curier.getRecenzii()) {
                    System.out.println(recenzie);
                }
            }
        } else {
            System.out.println("Nu s-a gasit niciun curier cu acest nume.");
        }
    }

    public void afiseazaTopLocaluri() {
        List<Localuri> localuriSortate = new ArrayList<>(localuri.values());
        localuriSortate.sort((l1, l2) -> Double.compare(l2.getRating(), l1.getRating()));

        int topCount = Math.min(3, localuriSortate.size());
        for (int i = 0; i < topCount; i++) {
            Localuri l = localuriSortate.get(i);
            System.out.println((i + 1) + ". " + l.getNume() + " - Rating: " + l.getRating());
        }
    }

}
