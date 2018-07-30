# Pluto
##### Autor projektu: Bartłomiej Pawelski

## O programie Pluto
Pluto jest prostą aplikacją służącą do asystowania w sędziowaniu meczów siatkówki, która jak dotąd rozrosła się do rozmiarów większych niż zakładane na początku (na ten moment składa się na nią około 600 linijek Javy i 700 linijek XML).

## Budowa programu
Backendowa część programu Pluto składa się na ten moment z ośmiu plików:
* **[Match.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/Match.java)** - klasa obiektu Match, przechowującego informację o pojedynczym meczu
* **[MenuActivity.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/MenuActivity.java)** - klasa zawiera metody odpowiadające za przenoszenie użytkownika do właściwych ekranów po naciśnięciu odpowiedniego buttona w menu głównym aplikacji
* **[PrematchActivity.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/PrematchActivity.java)** - klasa pobierająca od użytkownika nazwy drużyn, zanim przejdzie on do sędziowania meczu
* **[MatchActivity.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/MatchActivity.java)** - właśnie w tej aktywności ma miejsce właściwe sędziowanie, a więc dodawanie gemów w przypadku zdobycia przez daną drużynę punktu
* **[AftermatchActivity.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/AftermatchActivity.java)** - wyświetla rezultat meczu, łącznie z wynikami poszczególnych setów
* **[HistoryActivity.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/HistoryActivity.java)** - pokazuje listę wszystkich meczy rozegranych jak dotąd w aplikacji
* **[MatchAdapter.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/MatchAdapter.java)** - adapter umożliwiający wyświetlanie obiektów typu Match na liście w HistoryActivity
* **[HistoryDatabaseHelper.java](https://github.com/Bartek3/Pluto/blob/master/app/src/main/java/com/bartek/pluto/HistoryDatabaseHelper.java)** - klasa typu helper dla bazy danych SQLite używanej przez program - zawiera wszystkie metody używane podczas pracy z bazą danych

## Kierunek rozwoju
Poza eliminacją drobnych błędów i refaktoryzacją kodu, planuję dodać do aplikacji obsługę wielojęzyczności - wstępnie możliwość zmiany języka z angielskiego na polski i odwrotnie. Po tym, dodam aplikację na platformę Google Play.



