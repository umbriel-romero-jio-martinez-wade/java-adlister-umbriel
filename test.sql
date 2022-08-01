SELECT a.id,c.name,a.title,a.description,a.user_ID
                FROM ads AS a
                JOIN category_and_ads caa on a.id = caa.ad_id
                JOIN category c on caa.category_id = c.id
                WHERE c.name ='Other';