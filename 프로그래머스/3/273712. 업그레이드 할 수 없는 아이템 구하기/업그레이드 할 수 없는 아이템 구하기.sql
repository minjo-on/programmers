-- 코드를 작성해주세요
select item_id, item_name, rarity
from item_info
where not exists (
    select 1 from item_tree where item_info.item_id = item_tree.parent_item_id 
)
order by item_id desc;