
--Char 1
INSERT INTO character (maxHp, ad, ap, klasse, name, description) VALUES (4000, 2, 80, 'TANK', 'KV-1S', 'DER KV-1S ist ein sowjetischer TANK der Stufe 6' );
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Stimpack' , 0, 'Regenerates 2% missing heath every second', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Absorbing' , 1, 'GAIN 10% current Health shield cd 30 for 2.5 sec', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Ignite' , 2, 'DEAL 20 + 500% ap dmg per second for 5 seconds cd 10', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Hurt' , 3, ' DEAL 120 + ad damage cd 10', 1);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Pump Up' , 4, 'Get 0.5% current Health ap and ad for 10 sec cd 60', 1);

--Char 2
INSERT INTO character (maxHp, ad, ap, klasse, name, description) VALUES (4000, 2, 80, 'TANK', 'T-90', 'Der T-90 ist ein Tank der russischen Armee, welcher vom Verteidigungsministerium der Russischen Föderation 1992 eingeführt wurde.' );
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Comming Late' , 0, 'GAIN 5 Ad and 1 ap extra every 5 min', 2);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Granade' , 1, 'Deal 40 + 100% ap dmg to all 10', 2);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Vampire' , 2, 'Deal 120 + ad dmg and heal for 10% dmg  cd 10', 2);


INSERT INTO ability (name, aid, description, charid ) VALUES  ('Hurt' , 3, ' DEAL 120 + ad damage cd 10', 2);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Pump Up' , 4, 'Get 0.5% current Health ap and ad for 10 sec cd 60', 2);

-- Char 3
--TODO
INSERT INTO character (maxHp, ad, ap, klasse, name, description) VALUES (4000, 2, 80, 'TANK', 'KV-1S', 'DER KV-1S ist ein sowjetischer TANK der Stufe 6' );
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Stimpack' , 0, 'Regenerates 2% missing heath every second', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Absorbing' , 1, 'GAIN 10% current helth shield cd 30 for 2.5 sec', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Ignite' , 2, 'DEAL 20 + 500% ap dmg per second for 5 seconds cd 10', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Hurt' , 3, ' DEAL 120 + ad damage cd 10', 3);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Pump Up' , 4, 'Get 0.5% current Helth ap and ad for 10 sec cd 60', 3);

--Char 4
INSERT INTO character (maxHp, ad, ap, klasse, name, description) VALUES (600, 0, 80, 'DPS', 'Kalaschnikow', 'Sowjetischer Damage Dealer; Entwikelt 1946 einer der meistbenutzer Damage Dealer' );
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Krit' , 0, '10% Change that a ability ist cast 2x excluding ult', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Attack' , 1, 'DEAL 100% ad damage cd 2.5', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Headshot' , 2, 'DEAL 110% ad damage + 25% krit for 2x dmg cd 15', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Rage-mode' , 3, ' Gain 40% ad for 1.5 seconds cd 25', 4);
INSERT INTO ability (name, aid, description, charid ) VALUES  ('Spray and Pray' , 4, 'Shoot 8 time ability headshot  cd 80', 4);