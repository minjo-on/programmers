-- 코드를 입력하세요
SELECT r.rest_id, r.rest_name, r.food_type, r.favorites, r.address, round(avg(v.review_score), 2) as score
from rest_info r join rest_review v on r.rest_id = v.rest_id
where r.address like '서울%' 
group by r.rest_id
order by score desc, r.favorites desc;