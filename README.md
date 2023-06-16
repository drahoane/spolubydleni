# PDA-Spolubydlení

## Popis aplikace
Aplikace poskytuje rozhraní pro správu financí nad řadou domácností. Na úvodní obrazovce je uživateli poskytnut formulář pro přihlášení se a nebo případnou registraci. Při pokusu o přihlášení pomocí tlačítka umístěného ve spodní části obrazovky se uživateli zobrazí alert okno, které buď uživatele informuje o chybě a nebo úspěšném přihlášení. Po přihlášení se z databáze zobrazí výpis domácnosti, jejichž členem uživatel je, jestliže takové existují. Pomocí spodního navigačního baru se může přesměrovat na vytvoření domácnosti, zobrazení výpisu jeho domácností a nebo zobrazení si notifikací. Prokliknutím přes některou z domácností se uživatel ocitne na obrazovce s navigačním menu pro zobrazení listu útrat nebo členů dané domácnosti. Zároveň má již k dispozici floating button, kterým lze rychle přidat novou útratu. Součástí formuláře pro vytvoření útraty je možnost si vybrat, kterých členů se bude útrata týkat a jak bude částka útraty mezi tyto členy rozdělena (naimplementovaná část zahrnuje pouze možnost equally). Skrze výpis veškerých útrat si může uživatel nechat zobrazit detail dané útraty. Zde si může přečíst či zanechat komentář, editovat útratu a nebo ji z domácnosti vymazat pomocí ikonek vpravo nahoře.

Aplikace byla testována na virtuálních zařízeních Pixel 2 a Pixel 6 pomocí emulator rozhraní poskytnuté android studiem. Taktéž byla vyzkoušena na fyzickém zařízení Xiaomi skrze wifi připojení. Jako databázi jsme zvolili relační databázový systém SQLite. Aplikace používá Gradle API verzi 30.

## Lo-Fi prototyp
https://www.figma.com/proto/KS8R9CFwxXftHzZkYgxUKj/PDA?node-id=53795-27513&scaling=scale-down&page-id=11%3A1833&starting-point-node-id=53795%3A27513&show-proto-sidebar=1

## HE Testování
Pro testování aplikace jsme si zvolili Heuristickou analýzu. Po dokončení testování pak byly tyto chyby ve výsledném designu Figmy opraveny.
Testování proběhne po jednotlivých krocích, dle Nielsenovi 1994 analýzy.

#### Viditelnost statusu systému
_Systém informuje uživatele o všem podstatném, co se děje na jeho obrazovce ale i mimo ní._ 
- P1: Horní panel né vždy zobrazoval jasnou informaci o dané obrazovce, na které se užívatel nacházel. Konkrétně při vytváření domácnosti, která je rozdělena na dvě části, nebylo v druhé části jasné, k čemu slouží daná obrazovka.
- Priorita: 2 (nejasný postup vytváření domácnosti, důležité odstranit)
Shoda mezi systémem a reálným světem 
Systém není zbytečně komplikovaný, snaží se uživateli naslouchat.
Po analýze systému jsme dospěli k názoru, že systém a jeho uživatelská přívětivost je správně nastavena. Aplikace je tedy uživatelsky přívětivá.

#### Ovládání a uživatelská svoboda
_Systém musí předpokládat, že uživatel udělá chybu a poskytnout mu cestu zpět._
- P2: Po kliknutí na přidat výdaj a následným zobrazením této obrazovky bylo obtížné dostat se zpátky na předešlou obrazovku. Byla zde možnost využít spodní menu, které ale nebylo v této situaci vhodné. Vyskytla se situace, kdy uživatele spodní menu nepřeneslo na požadovanou obrazovku, tedy o krok zpátky. Poznámka: na obrazovku přidat výdaj se dá dostat z jiných obrazovek jako z těch, které jsou v spodním menu.
- Priorita: 4 (nemožnost jít o krok zpět, možnost jít o více kroků zpátky)
- P3: Hned v první obrazovce, při přihlašování se do systému byla nalezena chyba. Po kliknutí a přemístění se do obrazovky pro registraci zde nebyla možnost vrátit se zpátky. Kliknutí na tlačítko pro registraci zde byla jednosměrná cesta, tedy jestli se uživatel chtěl naozaj jenom přihlásit neměl zde cestu zpátky. Možnost tehdy byla opětovná registrace což je blbost, když má uživatel již založený účet. Druhou a pravděpodobnější je vypnutí a zapnutí aplikace, kde ho aplikace přenese na hlavní obrazovku, což je stránka pro přihlášení.
- Priorita: 1 (nemožnost jít o krok zpět, nutnost restartu aplikace)

#### Konzistence a standardy
_Systém musí plnit standardy moderních mobilních aplikací a využívat známé komponenty._
- P4: Obrazovky pro přehled, souhrn výdajů a seznam členů domácnosti obsahovaly element, který nesplňoval standardy moderních aplikací M3. Jednalo se o tlačítko vpravo dole, pro přidání nové útraty. Tlačítko bylo obsaženo v standardech M2. Jelikož je ale aplikace vytvořena pro standard M3, nebyla táto úprava přípustná. Poznámka: nejdřív jsme si zkoušeli jednu obrazovku v M2 a nejak se nam jeden z elementů přenesl až do výsledku.   
- Priorita: 5 (nesplnění standardů, ovšem se jedná jenom o starší standard s rovnakou funkčností)

#### Prevence chyb
_Systém by měl zabránit chybám uživatele a poskytnout mu alternativu._
- P5: V obrazovce pro pozvání lidí k domácnosti se zde nacházelo jenom vstupní pole pro zadání uživatele. Uživatel nebyl informován o podobných uživatelích počas psaní jména daného uživatele. Po napsání jeho jména a odeslání pozvánky v případě chyby při psaní jména, nebylo uživatel informován o pravděpodobné chybě a možných řešení chyby.
- Priorita: 3 (stav, kdy si uživatel myslí, že úspěšně pozval jiného uživatele, nebo taky ne)
Spíše rozpoznání než spomínaní
Systém je rozpoznatelný díky lehké screen mapě a dobrýmu rozložení aplikace.
Dovolíme si tvrdit, že je práce s aplikací intuitivní a je lehké už po pár použitích prakticky automaticky najít to co uživatel hledá.

#### Flexibilita a efektivita použití
_Systém poskytuje novému uživateli jednoduchou cestu a zkušenému pak zkratky v aplikaci._
- P6: Po překliknutí se do pravého horního menu a zvolení možnosti buď profil nebo nastavení zde byla poměrně divná cesta zpátky. Po zobrazení jedné z této obrazovek a následním kliknutí šipky zpět byl uživatel přesměrován vždy na stránku s domácnostmi. Dává to smysl z pohledu nového uživatele, který se takto jen těžko ztratí, ovšem z pohledu zkušeného uživatele se zde jednalo o přílišnou zajížďku. Bylo to především viditelný při kliknutí z obrazovky pro přidání nebo úpravu výdaje, kde cesta zpátky po této akci představovala hned 3 prokliknutí, aby se uživatel dostal zpátky kde byl.
- Priorita: 4 (neefektivita dizajnu, ovšem jenom z pohledu zkušeného uživatele)

#### Estetika a minimalistický dizajn
_Systém zobrazuje jenom podstatné informace._
Z našeho pohledu jsme se od začátku snažili přistupovat k aplikaci minimalisticky a poskytnout vždy jenom podstatné informace. Proto si myslíme, že aplikace tento bod splňuje.

#### Pomoc uživateli spoznat, vysvětlil a opravit chyby
_Systém poskytuje uživateli chybové hlášky, které ho zavedou k opravě._
Při zadání špatných údajů zejména při přihlášení a registraci se zobrazí chybová hláška, která informuje uživatele o chybě. Ve Figmě jsme se chybovými hláškami nezabíraly, jelikož zde uživatel reálně vyplňuje vstupní pole a tedy není možné to zde kontrolovat. To platí i při ostatních situacích například přidání neexistujícího uživatele, přidání výdaje, který je záporný a podobně. V reálné aplikaci by se ale chybové

#### Pomoc a dokumentace
_Systém poskytuje uživateli dokumentaci a základní pomoc k celé aplikaci._
Pomoc a dokumentace aplikace se nachází v pravým horním menu. Samozřejmě tento překlik nikam nevede, ale zde by se v reálné aplikaci tato pomoc a dokumentace nacházela.

## Informal testování
Závěrem uživatelského testování vyplynuly následující podněty. Jedním z nich byla nespokojenost s nutností registrace. Bylo nám navrženo, že by registrace sloužila pouze pro případy zálohování. Dále nám byl vytknut design spodního navigačního menu pro svou jednoduchost a podobnost ikonek pro akce zobrazení všech domácností a upozornění. Poslední připomínkou byla blízkost ikonky pro editaci a pro smazání v rámci obrazovky detailu, které by mohlo vyvolat nežádoucí akci, nicméně dialogové okno pro potvrzení o vymazání útraty považovali za dostatečné řešení. Naopak pozitivně uživatelé hodnotili přehlednost jednotlivých obrazovek a intuitivní umístění příslušných akčních ikonek a tlačítek. Také bylo oceněno informování uživatele o dění mezi akcemi pomocí alert oken.

