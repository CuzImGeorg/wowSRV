INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (4500, 2, 80, 'TANK', 'KV-1S', 'DER KV-1S ist ein sowjetischer TANK der Stufe 6' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (4000, 2, 100, 'TANK', 'T-90', 'Der T-90 ist ein Tank der russischen Armee, welcher vom Verteidigungsministerium der Russischen Föderation 1992 eingeführt wurde.' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (4200, 4, 80, 'TANK', 'Ariete', 'Italienischer KampfTank, aktuell gibt es 140 der Art in Italien' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (600, 0, 80, 'DPS', 'Kalaschnikow', 'Sowjetischer Damage Dealer; Entwikelt 1946 einer der meistbenutzer Damage Dealer' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (500, 0, 90, 'DPS', 'Ar-15', 'ArmaLite 15, developed in US, good for armor penetration' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (600, 0, 80, 'DPS', 'MP-5', 'ist eine 9 x 19 mm Parabellum-Maschinenpistole in den 1960er Jahren vomIngenieuren des deutschen Kleinwaffenherstellers Heckler & Koch entwickelt.' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (400, 3, 20, 'SUP', 'Mercy', 'hat keinen Frieden gegen Gegner' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (400, 3, 20, 'SUP', 'HEILER', 'Einer der effizientesern HEILER aus DEUTSCHLAND für besten HEIL und SCHILD immer  EINSTAZBREREIT um dich und deine STAFFEL zu BESCHÜTZEN!' );
INSERT INTO charakter (maxHp, ap, ad, klasse, name, description) VALUES (400, 3, 20, 'SUP', 'Sage', 'bo' );


INSERT INTO ability (name, aid, description, charid ) VALUES  ('Stimpack' , 0, 'Regenerates 2% missing heath every second', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Absorbing' , 1, 'GAIN 10% current Health shield cd 30 for 2.5 sec', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Ignite' , 2, 'DEAL 20 + 500% ap dmg per second for 5 seconds cd 10', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Hurt' , 3, ' DEAL 120 + ad damage cd 10', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Pump Up' , 4, 'Get 0.5% current Health ap and ad for 10 sec cd 60', 1);

INSERT INTO ability (name, aid, description, charid ) VALUES  ('Coming Late' , 0, 'GAIN 5 Ad and 1 ap extra every 5 min', 2);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Granade' , 1, 'Deal 40 + 100% ap dmg to all 10', 2);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Vampire' , 2, 'Deal 120 + ad dmg and heal for 10% dmg  cd 10', 2);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Block' , 3, ' Gain 100+40*ap shield for 3 sec cd 25', 2);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Pump Up' , 4, ' Get 20% max heath as for 10 sec and heal 10% max heath everey 5 seconds cd 80', 2);

INSERT INTO ability (name, aid, description, charid ) VALUES  ('Re-Schield' , 0, 'Regenerates 2% missing heath every second', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Absorbing' , 1, 'Deal 40 + 1 % max heath  dmg to all cd 10', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Ignite' , 2, 'Deal 120 + 40% ad dmg', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Hurt' , 3, 'Heal urself for 50 + 2ß*ap dmg', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Pump Up' , 4, 'Gain 1200 + 100 * ap shield for 10 sec', 3);

INSERT INTO ability (name, aid, description, charid ) VALUES  ('Krit' , 0, '10% Change that a ability ist cast 2x excluding ult', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Attack' , 1, 'DEAL 100% ad damage cd 2.5', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Headshot' , 2, 'DEAL 110% ad damage + 25% krit for 2x dmg cd 15', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Rage-mode' , 3, ' Gain 40% ad for 1.5 seconds cd 25', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Spray and Pray' , 4, 'Shoot 8 time ability headshot  cd 80', 4);

INSERT INTO ability (name, aid, description, charid ) VALUES  ('Echo' , 0, '30% to  deal a extra of 40 + 50% ad dmg on ability cast', 5);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Attack' , 1, 'DEAL 50+ 100% ad damage', 5);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Penetrate' , 2, 'Deal 50 + 70% ad and ignores schied', 5);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Double attack' , 3, 'DEAL 50+ 200% ad damage cd 8', 5);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Empower' , 4, 'Gain 100% ad for 10 sec cd 90', 5);

INSERT INTO ability (name, aid, description, charid ) VALUES  ('Learn' , 0, 'Every time u hit u have a change of 10 % to get + 2 ad', 6);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Attack' , 1, 'DEAL 100% ad damage cd 2.5', 6);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Shrabnel' , 2, 'DEAL 120% ad damge and 20% ad damage to all others cd 15', 6);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Spray' , 3, 'Fire 5 patrons that each deal 60% ad every 0.5 sec dmg cd 20', 6);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Empower' , 4, 'Gain 5 ad cd 90', 6);

INSERT INTO ability (name, aid, description, charid ) VALUES  ('Scale' , 0, 'Gain every 5 min 1 ap', 7);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Heal' , 1, 'HEAL 100 + 50 * ap cd 15', 7);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Schield' , 2, 'Give allies 10ad + ap/2 ad', 7);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('attack' , 3, 'Attack enemie for 10 * ap', 7);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Empower' , 4, 'Heall all allies for 500 and give them 50 ad for 8 sec cd', 7);

INSERT INTO ability (name, aid, description, charid ) VALUES  ('Scale' , 0, 'Gain every 5 min 1 ap', 8);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('HEAL' , 1, 'HEAL 100 + 50 * ap cd 15', 8);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Buff' , 2, 'Give allies 10ad + ap/2 ad', 8);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Attack' , 3, 'DEAL 50+ 200% ad damage cd 8', 8);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Heal and Buff' , 4, 'Heall all allies for 500 and give them 50 ad for 8 sec cd', 8);


INSERT INTO ability (name, aid, description, charid ) VALUES  ('Scale' , 0, 'Gain every 5 min 1 ap', 9);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('heal' , 1, 'HEAL 100 + 50 * ap cd 15', 9);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('heal' , 2, 'HEAL 80 + 4 * ap + 20 + 2 * ap to all        cd 25', 9);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('boom' , 3, 'Throw a bomb at the enemies dealing 60 dmg to all', 9);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Unkilable' , 4, 'Give ur allies 10000 schied for 5 seconds cd 140', 9);
