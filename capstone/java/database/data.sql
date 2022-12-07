BEGIN TRANSACTION;

--INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('ricardo', '$2a$10$afuUAXrV/kKQjkr7v1OLg.AsebZxt2lg4rzhoUMTxSsP/Jqfw4MUS', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('jane', '$2a$10$aFWHuZWqFAyl8b.ou2fzFuMvXfRJ/HqI1uM85Ah0N6TxxVBmOG4O.', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('spencer', '$2a$10$U0q1o1SW5nCa6BHlfNqLHug8J0mcOjv6zBcnV66OYbJamaID.HIt.', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('connor', '$2a$10$Xvtmp.i43yBEE8uzmX8fhObRWOmAZiHrz7Px3OM1wFVNjup6IYGXq', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('david', '$2a$10$.ufkAXypZWEphMv8R36jzO8uDnGa2ZznqhIftkicReHrRG.9OZ8Ei', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('isaac', '$2a$10$ql9/Rl0Z.kQNDgHjwbxa0enTEQSx70QbuO9EHfACifLUsBNkKupp6', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('justin', '$2a$10$0RYBCU2qis96/DdJJQyU8ek4T65tdJcxMVSphDdWQ3.U2ljK3LWTG', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('ken', '$2a$10$mRSrMCD1786MKP.pOVdJouemKy.xOBgYRFEGqC8jdfIO77M6JJQku', 'ROLE_BEERLOVER');


COMMIT TRANSACTION;
