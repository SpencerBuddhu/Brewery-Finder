BEGIN TRANSACTION;

-- USERS
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('ricardo', '$2a$10$afuUAXrV/kKQjkr7v1OLg.AsebZxt2lg4rzhoUMTxSsP/Jqfw4MUS', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('jane', '$2a$10$aFWHuZWqFAyl8b.ou2fzFuMvXfRJ/HqI1uM85Ah0N6TxxVBmOG4O.', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('spencer', '$2a$10$U0q1o1SW5nCa6BHlfNqLHug8J0mcOjv6zBcnV66OYbJamaID.HIt.', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('connor', '$2a$10$Xvtmp.i43yBEE8uzmX8fhObRWOmAZiHrz7Px3OM1wFVNjup6IYGXq', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('david', '$2a$10$.ufkAXypZWEphMv8R36jzO8uDnGa2ZznqhIftkicReHrRG.9OZ8Ei', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('isaac', '$2a$10$ql9/Rl0Z.kQNDgHjwbxa0enTEQSx70QbuO9EHfACifLUsBNkKupp6', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('justin', '$2a$10$0RYBCU2qis96/DdJJQyU8ek4T65tdJcxMVSphDdWQ3.U2ljK3LWTG', 'ROLE_BEERLOVER');
INSERT INTO users (username,password_hash,role) VALUES ('ken', '$2a$10$mRSrMCD1786MKP.pOVdJouemKy.xOBgYRFEGqC8jdfIO77M6JJQku', 'ROLE_BEERLOVER');

-- ADDRESSES
INSERT INTO addresses (street_address, city, state, zipcode)
VALUES('1744 Donlon St.', 'Ventura', 'CA', '93003');

INSERT INTO addresses (street_address, city, state, zipcode)
VALUES('4880 Colt St.', 'Ventura', 'CA', '93003');

INSERT INTO addresses (street_address, city, state, zipcode)
VALUES('307 Bryant Street', 'Ojai', 'CA', '93023');

INSERT INTO addresses (street_address, city, state, zipcode)
VALUES('5777 Olivas Park Dr Unit S', 'Ventura', 'CA', '93003');

-- BREWERIES
INSERT INTO breweries (brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo, brewery_image, is_active)
VALUES('MadeWest Brewing Company', 2, 'https://madewest.com/', 'beer@madewest.com', 1, '8059475002', 'MadeWest is the result of lifelong friends seeking to share quality handmade craft beer with our beloved home state. Our vision is inspired by California’s legacy of adventure and innovative design—and our beer reflects that as much in the great outdoors as from a barstool at one of our two Ventura taprooms. Wherever you take MadeWest, you’ll take the spirit of the West Coast with you.', 'https://cdn.shopify.com/s/files/1/2653/8302/files/MW_Circle_Logo_720x.png?v=1613765700', 'https://cdn.shopify.com/s/files/1/2653/8302/files/gem20171222madewest_08_24398191240_o_1500x.jpg?v=1613714972','true');

INSERT INTO breweries (brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo, brewery_image, is_active)
VALUES('Topa Topa Brewing Company', 3, 'https://topatopa.beer/', 'hi@topatopa.beer', 2, '8055354366', 'Topa Topa Brewing Co. was founded in 2015 in Ventura, CA, nestled between the Topa Topa mountains in Ojai and the salty shores of the Pacific. We believe the people should drink great beer! And we love that we get to craft great beer amongst a landscape and community that inspires us.Topa Topa is upheld by a trifecta of values: quality, craftsmanship, and community spirit. This means we use the freshest ingredients, we work with the most skilled brewers around, and we thrive on uplifting and unifying our community. We get stoked on good surf, a long hike, a tough climb, or a good-old-fashioned day of hard work. And we think these days are made all the better when we’re surrounded by friends with a cold beer in hand. So next time you’re near one of our tap rooms— whether in Ventura, Ojai, Santa Barbara or Camarillo— pull up a chair, grab a fresh pint, and enjoy the company. Or if you’re gearing up to take to the trails or the sea, never fear, we have 6-packs, growlers, and crowlers aplenty.', 'https://scontent-dfw5-2.xx.fbcdn.net/v/t31.18172-8/19693531_800272060150551_346240175969820292_o.png?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=Gb8KndnVIywAX8kq11l&_nc_ht=scontent-dfw5-2.xx&oh=00_AfDJm5wjgPp_tV_5QYJHoFU83QAqxihYqvDWRlYonMuwhA&oe=63B6DE25', 'https://pagestudio.s3.theshoppad.net/topa-topa-brewing-company/ddbc10c280ec9185f1ffa17eec39f263.jpg','true');

INSERT INTO breweries (brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo, brewery_image, is_active)
VALUES('Ojai Valley Brewery', 4, 'https://ojaivalleybrewery.com/', 'cmartinez@ojaivalleyinn.com', 3, '8057989282', 'Brewing at 307 Bryant Street, in Ojai California since 2017: We believe in the magic of Ojai, and Indigenous Ojai Botanicals. Ojai is a place where people have always come for recovery and fortification. Ojai is Chumash for ''“The Nest”''. It''s a place where good people find good people, through nature and unique and meaningful experiences. It’s also a place that attracts a wide variety of expert crafts people to a rather small community. Ojai lives in our beers and brews. Inoculated by the unfiltered culture of our community, by the hands of our local brewers, in the pure Ojai water, and in the indigenous herbs, fruits, and flowers we infuse into our one-of-a-kind creations. We make beer that is an expression of our environment, to commune with the natural world that surrounds us. We share these moments together. We find unity in the mutual appreciation of these natural gifts and in the good times we share.', 'https://images.squarespace-cdn.com/content/v1/56d7bb6545bf212e1e93beed/c68bb63a-d04b-46bd-bf7b-644600f411c1/Icon.png?format=1500w', 'https://lh3.googleusercontent.com/p/AF1QipOg6WJR6WisrtznlRdzRdR61mwLITdMoDdMAcM=s1360-w1360-h1020', 'true');

INSERT INTO breweries (brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo, brewery_image, is_active)
VALUES('Poseidon Brewing Company', 5, 'https://poseidonbrewingco.com/', 'info@poseidonbrewingco.com', 4, '8054770239', 'You tend to do what you love in life. Or at least that’s been a motto that Brian Oliver, Poseidon’s co-proprietor and head brewer, has made a point to live by. As far back as 2007, when he was stationed in Iraq, he discovered craft beer—and that he loved it. So in his downtime, he researched homebrewing…and got the hankering to pursue it himself. No surprise, making a batch didn’t seem too hard a feat for this Navy-trained underwater construction diver. Right after returning to Ventura County, California, Brian took up the hobby along with his wife, Vinita, who also had an appreciation for high-quality beers. Together the couple sampled their brews with friends and neighbors, noticing the compliments, good times, and real sense of community their hobby created. It was inspiring, so much so that Brian, now at the tail end of his 23-year Navy career and feeling confident about his craft, took a leap and launched Poseidon Brewing Co., along with Vinita’s help.', 'https://craftpeak-cooler-images.imgix.net/poseidon-brewing-co/logo-color-01.png?auto=compress%2Cformat&ixlib=php-3.3.0&s=40105df9b2c16e791acc2d53e84c778c', 'https://craftpeak-cooler-images.imgix.net/poseidon-brewing-co/02_Poseidon-2022-schafphoto-2887.jpg?auto=compress%2Cformat&ixlib=php-3.3.0&s=557a68d2f445482299edda7cffbe1ce4', 'true');

-- BEERS
INSERT INTO beers (beer_name, beer_description, image, abv, beer_type, is_active)
VALUES('Standard', 'A clean, crisp, sessionable, light ale, this Great American Beer Fest gold-medal winner is easy drinking and full of flavor. It has a light, grainy, malt backbone and a prominent floral hop character with a dry, refreshing finish. HOPS: Saaz, Mandarina Bavaria', 'https://cdn.shopify.com/s/files/1/2653/8302/products/madewest-standard-4pack_1800x1800.jpg?v=1636506475', 5.6, 'Blonde Ale', 'true');

INSERT INTO beers (beer_name, beer_description, image, abv, beer_type, is_active)
VALUES('Pale', 'This heavily hopped West Coast Pale Ale is bursting with a bright citrus and fruity hop complexity. It has just enough malt presence to allow the loads of hops to shine through. This crisp, hop forward beer has a dry, refreshing finish. HOPS: Mosaic, Simcoe, Ekuanot', 'https://cdn.shopify.com/s/files/1/2653/8302/products/madewest-Pale4pack_1800x1800.jpg?v=1636506385', 5.6, 'Pale Ale - American', 'true');

INSERT INTO beers (beer_name, beer_description, image, abv, beer_type, is_active)
VALUES('IPA', 'This West Coast IPA is loaded with a fresh tropical fruit character. A light malt base provides a platform for showcasing the complex hop bouquet of pineapple, candy-like stone fruit and citrus tones. This IPA has a mellow bitterness and a smooth, pleasantly dry finish. HOPS: El Dorado, Citra, 07270, Ekuanot, Eureka!', 'https://cdn.shopify.com/s/files/1/2653/8302/products/madewest-ipa-fourpack_1800x1800.jpg?v=1636506299', 6.9, 'IPA - American', 'true');

INSERT INTO beers (beer_name, beer_description, image, abv, beer_type, is_active)
VALUES('Hazy IPA', 'A hazy IPA packed with a jaw-dropping quantity of Mosaic hops. This aromatic IPA has a ripe juicy character with notes of fresh peaches and mango. A soft, silky mouthfeel is complemented by a smooth, refreshing finish. HOPS: Mosaic, Simcoe, Eureka', 'https://cdn.shopify.com/s/files/1/2653/8302/products/madewest-hasy-ipa-4pack_1800x1800.jpg?v=1636506584', 7, 'IPA - New England / Hazy', 'true');

-- BREWERIES_BEERS
INSERT INTO breweries_beers (brewery_id, beer_id) VALUES(1, 1);
INSERT INTO breweries_beers (brewery_id, beer_id) VALUES(1, 2);
INSERT INTO breweries_beers (brewery_id, beer_id) VALUES(1, 3);
INSERT INTO breweries_beers (brewery_id, beer_id) VALUES(1, 4);

-- REVIEWS
INSERT INTO reviews (review_text, user_id, image) 
VALUES('I buy this beer weekly and cant get enough. Very crisp and refreshing. It''s also one of the few beers my lady will actually drink. Wish you sold 6 packs!', 5, '');

INSERT INTO reviews (review_text, user_id, image) 
VALUES('Nice pilsner style with great flavor. More hops would make it perfect.', 6, '');

INSERT INTO reviews (review_text, user_id, image) 
VALUES('Had to give it a shot after the GABF win. A well perfected pilsner with that grainy malty flavor perfectly balanced with some hop flavor.', 7, '');

INSERT INTO reviews (review_text, user_id, image) 
VALUES('The Standard is always my beach beer Standard!', 8, '');

-- BEER_REVIEWS

INSERT INTO beer_reviews (beer_id, review_id) VALUES(1, 1);
INSERT INTO beer_reviews (beer_id, review_id) VALUES(1, 2);
INSERT INTO beer_reviews (beer_id, review_id) VALUES(1, 3);
INSERT INTO beer_reviews (beer_id, review_id) VALUES(1, 4);

COMMIT TRANSACTION;
