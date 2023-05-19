package com.anetsapplication.app.db

class ExpensesDBHelper {
    /** Tu by mala byť DB implementácia pre Expenses, moja pre overview, tvoja pre add, edit, delete
     * UserdataDB je o dosť viac easy ako HouseholdDB, takže skôr vychádzaj z toho ľahšieho :)
     * V ňom je iba princíp add (add user), takže presne to čo potrebuješ, v druhom je aj render
     *
     * V tomto súbore bude treba vytvoriť tabuľku Expenses s nejakými stĺpcami
     * Jeden z nich bude musieť byť household_name, ktoré je Unique a teda IDčkom
     * Normálne by to bolo číslo, ja som ale spravil názvy Unique aby sme ich mohli používať ako ID
     *
     * V activities, ktoré som implementoval si medzi views prenášam dáta: username a household_name
     * Minimálne household_name budeš potrebovať a v kóde sú tieto dáta prenesené skoro všade
     *
     * Nechcem ti do toho moc kecať a riadiť ťa, ale ak budeš stratená tak ti to možno pomôže :)
     * Asi by som začal s "add expense equally" a nejak takto:
     * 1. implementácia tejto classy, teda vytvorenie databázy cez override metody
     * 2. implementácia insertData funkcie pre vytvorenie nového Expense
     * 3. v Activity vytvoriť listener na button, ktorým budeš potvrdzovať pridanie Expense
     * 4. do tohto listenera vlož všetky kontroly podobne ako v LoginActivity
     * 5. ak prejdú kontroly, hodnota sa zapíše do DB tadaaaa :)
     *
     * Ako si overiť, že sa hodnota fakt zapísala do DB?
     *
     * A: Do kódu si môžeš vpisovať Log.e("name", "value") a v "Run" ti to bude vypisovať červenou
     * Log.e() používam napr. v HouseholdsActivity
     *
     * B: Od API 30 si hore cez View->Tool Windows->App Inspection zobraziť DB
     * V tomto App Inspection si naľavo hore zvolíš tento projekt a Database Inspector
     * Mne to na začiatku nešlo rozchodiť, musel som predtým vymazať cache
     * Cache sa maže: File -> Invalidate Caches... -> Invalidate and Restart
     * App Inspector neukazuje hodnoty v tabuľke predtým než bol zapnutý, takže ukáže iba live data
     * Stále je to ale dobré na debug
     *
     * Možno sa bude hodiť:
     *  - Ak ti bude crashovať Emulator a si si istá že to máš i tak správne, urob hard reset
     *  Ten spravíš tak, že v Emulatory pretiahneš ikonku appky do uninstall, teda ju odinštaluješ
     *  Tým sa premaže aj databáza a ideš od znova, narozdiel od tlačitka play, ktoré soft resetí
     *  - Všetok kód čo budeš potrebovať je v mojich classach čo som robil, DBHelpers a Activities
     *  - Keď budeš googliť problém, 95% odpovedí je v Jave, takže to treba prepísať do Kotlinu
     *  - Celkovo v kóde je strašne veľa nepotrebných riadkov, súborov a funkcií
     *  Ide o tie vygenerované Figmou, ale ja som taktiež nebol najefektívnejší niekedy :D
     *  Takže proste na estetiku kódu sa moc nesústreď, to by sme museli premazať polku súborov
     *  - Na "add Expense Equally" som ti nabindoval všetky potrebné veci na plusko od Expenses
     *  Odtiaľ teda môžeš začať, máš tam aj preposlaný aktuálny username a household_name
     *  - Pri vytváraní Expenses DB si to môžeš zľahčiť ako ja a spraviť primary key z názvu Expense
     *  Odpadne ti teda IDčko číselné, ktoré by si musela nejak schovávať cez .xml a preposielať
     *  To teda neviem ako sa robí, preto to robím takto :D
     * */
}