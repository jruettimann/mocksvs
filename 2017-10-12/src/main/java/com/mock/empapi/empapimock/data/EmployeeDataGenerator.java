package com.mock.empapi.empapimock.data;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

@Component
public class EmployeeDataGenerator {

    private static final String[] companies = {"Raiffeisen Schweiz Genossenschaft", "Raiffeisenbank Visperterminen", "Raiffeisenbank Risch-Rotkreuz", "Raiffeisenbank Wohlen", "Raiffeisenbank Freiburg Ost / Fribourg-Est"};
    private static String[] firstNamesForMen = {"Mohamed", "Sébastien", "Adriano", "Beat", "Peter", "Sylvio", "Silvia", "François", "Mischa", "Jeevithan", "Gion", "Loïc", "Joaquim", "Alan", "Salih", "Theo", "Arnold", "Bertrand", "Gregory", "Andri", "Cristiano", "Paulo", "Ismail", "Branko", "Giordano", "Santiago", "Yvan", "Remo", "Frédéric", "Gian-Andrea", "Denis", "Oliver", "Andres", "Simon", "Hans-Ruedi", "Cornelius", "Traugott", "Gallus", "André", "Daniel", "Gianluca", "Charles", "Giorgio", "Fluturim", "Ronnie", "Alfred", "Pedro", "Titus Georg", "Alfons", "Oliver", "Gion-André", "Karlheinz", "Dylan", "Harry", "Samir", "Cäsar", "Aurélien", "Peter Bernhard", "Pierluca", "Constant", "Andreas Karlheinz", "Hans-Jakob", "Curzio", "Loris", "Leander", "Marc Etienne", "Didier-Pierre"};
    private static String[] firstNamesForWomen = {"Karine", "Marylin", "Melanija", "Chiara", "Ludivine", "Marisa", "Véronique", "Anne", "Luisa", "Lynn", "Lise-Marie", "Frederike", "Rosa Maria", "Grace", "Leyla", "Marlies", "Laetitia", "Amanda", "Marla", "Tina", "Dana", "Morgana", "Iris", "Deborah", "Serap", "Ambre", "Christelle", "Marlise", "Donatella", "Giuliana", "Christiane", "Martine", "Luisella", "Marie-Noëlle", "Loreen", "Monia", "Milena Cristin", "Fabiana", "Nuria", "Magdalena", "Kimberly", "Giuanna", "Kyra", "Hülya", "Imelda", "Eileen", "Zorka", "Nilujana", "Mirina", "Silke", "Kornelia", "Marie", "Döndü", "Rica", "Julie", "Chantal", "Cristina", "Morena", "Verena", "Cyrielle", "Brunella", "Louisa", "Rachèle"};
    private static String[] lastNames = {"Räber", "Kick", "Hasan", "Jordil-Genoud", "Gürster", "Mrva", "Steffanina", "Loacker", "Fisch", "Grieco", "Dernjani", "Gonzalez Belmonte", "Marchon-Schönenberger", "Pellet", "Manzo", "Kirchner", "Ruscio", "Farnung", "Tatula", "de Zwart", "Korner", "Venetz", "Bumann", "Uysal", "Trenceva", "Bingisser-Kälin", "Caminada", "Cretton", "Scarpelli", "Giani", "Hank", "Kronig", "Goldschmid", "Dordevic", "Corviello", "Remus", "Breuss Hostettler", "Schopfer", "Riquen", "Battaglieri", "Besson", "Litz", "Speck", "Gschwend-Kälin", "Schlatter", "Hohl", "Jehle", "Ruef", "Frehner", "Providoli", "Kugler", "Gex", "Barrer", "Vuignier", "Marquis", "Welti", "Durakovic", "Pasini Musatti", "von Roten Pitteloud", "Ott", "Keller-Niederer", "Hert", "Pannatier", "Stucki-Baumann", "Cincera", "Pilloud", "Mahler", "Kies", "Carraro", "Jahrmarkt", "Garcia de Juan", "Karlen-Petrig", "Storni", "Elliscasis", "Bos", "Erismann", "Häfliger-Müller", "Zach-Bättig", "Romagnoli", "Gutic", "Pürro", "Collaud-Repond"};
    private static String[] bankNumbers = {"8000", "0801", "0495", "0319", "0878"};
    private static String[] jobTitles = {"Lernender", "Kundenberater", "Applikationsentwickler", "Externer Mitarbeiter", "Praktikant", "Mitglied der Bankleitung", "Leiter Trading", "Abteilungsleiter " + "", "Backend-Architektur", "Vermögensberater"};
    private static String[] jobRoles = {"Lehrlinge", "Mitarbeiter", "Abteilungsleiter", "Externer Mitarbeiter", "Gruppenleiter", null, null, "Mitarbeiter", "Mitarbeiter", "Mitarbeiter"};
    private static String[] jobFunctions = {"Fachspezialist Operations - Norm", "Berater Service Center Personal - Norm", "Consultant - Experte", "Investmentspezialist - Experte", "KMU-Berater - Senior", "Stammdaten", "Vermögensberatung", "Mitglied der Bankleitung", "Données de base", "Sales - Senior", "Produktmanager - Experte", "Investmentspezialist - Norm", "Presidente della Direzione", "Leiter Vertrieb", "Service Desk-Mitarbeiter - Senior", "Produktmanager - Junior", "SB Leasing - Senior", "Berufsbildung", "Formation professionnelle", "ICT-System-Spezialist - Junior", "Sistema di regolamentazioni", "Responsabile del personale", "Consultant - Junior", "Business-Analyst - Experte", "Wirtschaftsinformatiker - Senior", "Applikationsentwickler - Senior", "Führung - III", "Händler - Senior", "SB Rechnungswesen - Norm", "Berater Gruppenkommunikation - Senior", "Sales - Norm", "Kreditrisiko-Officer - Senior"};
    private static String[] jobFunctionLevels = {null, "3", "6", "5", "4", "2"};
    private static String[] groups = {"RAI Lab", "Digitale Kommunikation", "Kommunikation & Politik", "Einkauf", "00 Sirnach", "00 Wiler", "00 Lützelflüh", "00 Erlinsbach", "00 Wittenbach", "Fund Solutions", "00 Belfaux"};
    private static String[] departements = {"Services", "IT", "Niederlassungen & Regionen"};
    private static List<String> menImages = Lists.newArrayList("img/men/7fcbba165.jpg", "img/men/business.portrait.09-205x320.jpg", "img/men/business-portrait-photographer-bologna.jpg", "img/men/Executive_Headshot_8898.jpg", "img/men/male1.jpg", "img/men/male3.jpg", "img/men/male4.jpg", "img/men/male5.jpg", "img/men/male6.jpg", "img/men/male7.jpg", "img/men/male8.jpg", "img/men/male9.jpg", "img/men/male10.jpg");
    private static List<String> womenImages = Lists.newArrayList("img/women/4b6ed16ff791f4cf25066578a9296a61.jpg", "img/women/accelerate-stuttgart-Portrait-2.jpg", "img/women/business.portrait.cv_.resume.geneva.20.jpg", "img/women/female1.jpg", "img/women/female2.jpg", "img/women/female3.jpg", "img/women/female4.jpg", "img/women/female5.jpg", "img/women/female7.jpg", "img/women/female8.jpg", "img/women/female9.jpg", "img/women/female10.jpg", "img/women/female11.jpg", "img/women/female12.jpg", "img/women/female13.jpg", "img/women/female14.jpg");

    private Random random = new Random(123);

    public List<Employee> generateEmployees(int count) throws IOException {
        List<Employee> generatedEmployees = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            Gender gender = getRandomValue(Gender.values());
            String firstName = generateFirstName(gender);
            String lastName = getRandomValue(lastNames);
            URL picture = getPicture(gender);

            Employee employee = new Employee(i + 1);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(generateEmail(firstName, lastName));
            employee.setPhone(generatePhone());
            employee.setBankNumber(getRandomValue(bankNumbers));
            employee.setJobTitle(getRandomValue(jobTitles));
            employee.setJobRole(getRandomValue(jobRoles));
            employee.setJobFunction(getRandomValue(jobFunctions));
            employee.setJobFunctionLevel(getRandomValue(jobFunctionLevels));
            employee.setTeam(getRandomValue(groups));
            employee.setDepartment(getRandomValue(departements));
            employee.setCompany(getRandomValue(companies));
            employee.setEmpId(generateEmpId());
            employee.setImgFile(picture);
            employee.setPresenceState(getRandomValue(PresenceState.values()));
            employee.setProfileUrl("http://intranet.raiffeisen.ch/employees/profile/12345" + i + 1);
            generatedEmployees.add(employee);
        }
        return generatedEmployees;
    }

    private String generateEmail(String firstName, String lastName) {
        return makeEmailAddressSave(firstName) + "." + makeEmailAddressSave(lastName) + "@raiffeisen.ch";
    }

    String makeEmailAddressSave(String text) {
        return text.toLowerCase().replaceAll("[^a-z]", "");
    }

    private String generatePhone() {
        String phone = "+41";
        for (int i = 0; i < 9; i++) {
            phone += random.nextInt(9);
        }
        return phone;
    }

    private String generateFirstName(Gender gender) {
        if (gender == Gender.Man) {
            return getRandomValue(firstNamesForMen);
        } else if (gender == Gender.Woman) {
            return getRandomValue(firstNamesForWomen);
        } else {
            throw new IllegalArgumentException("Nicht unterstütztes Geschlecht");
        }
    }

    private String generateEmpId() {
        String empId = "";
        for (int i = 0; i < 5; i++) {
            empId += random.nextInt(9);
        }
        empId += "-";
        empId += random.nextInt(9);
        empId += "-";
        for (int i = 0; i < 5; i++) {
            empId += random.nextInt(9);
        }
        empId += "-";
        empId += random.nextInt(9);
        empId += "-";
        for (int i = 0; i < 5; i++) {
            empId += random.nextInt(9);
        }
        return empId;
    }

    private <E> E getRandomValue(E[] values) {
        return values[random.nextInt(values.length)];
    }

    private <E> E getAndRemoveRandomValue(List<E> values) {
        if (values.isEmpty()) {
            return null;
        }
        return values.remove(random.nextInt(values.size()));
    }

    private URL getPicture(Gender gender) {
        String pictureName = getPictureName(gender);
        if (pictureName == null) {
            return null;
        }
        return Resources.getResource(pictureName);
    }

    private String getPictureName(Gender gender) {
        if (gender == Gender.Man) {
            return getAndRemoveRandomValue(menImages);
        } else if (gender == Gender.Woman) {
            return getAndRemoveRandomValue(womenImages);
        } else {
            throw new IllegalArgumentException("Nicht unterstütztes Geschlecht");
        }
    }

    enum Gender {
        Man, Woman
    }
}
