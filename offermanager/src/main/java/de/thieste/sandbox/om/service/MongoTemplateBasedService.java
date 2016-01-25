package de.thieste.sandbox.om.service;

import com.mongodb.WriteResult;
import de.thieste.sandbox.om.bean.OfferMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created by thieste on 24.01.16.
 */
@Component
public class MongoTemplateBasedService implements OMDSService {

    private static final Logger LOG = LoggerFactory.getLogger(MongoTemplateBasedService.class);
    private final MongoTemplate mongoTemplate;


    @Autowired
    public MongoTemplateBasedService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    private boolean betterItemExists(String importId, String uniqueKey, int price) {

        final Criteria criteria = Criteria
                .where("importId").is(importId)
                .and("uniqueKey").is(uniqueKey)
                .and("filterReason").not().exists(true)
                .and("price").lte(price);

        final Query query = Query.query(criteria);

        return mongoTemplate.exists(query, OfferMetaData.class);
    }

    @Override
    public void save(OfferMetaData offerMetaData, String filterReason) {

        // update filterReason

        if (betterItemExists(offerMetaData.getImportId(), offerMetaData.getUniqueKey(), offerMetaData.getPrice())) {
            offerMetaData.setFilterReason(filterReason);
        } else {
            updateAllWithFilterReason(offerMetaData, filterReason);
        }

        removeOlderImports(offerMetaData.getImportId());
        mongoTemplate.save(offerMetaData, "offerMetaData");

    }

    @Override
    public void save(OfferMetaData offerMetaData) {
        mongoTemplate.save(offerMetaData);
    }

    private static final FindAndModifyOptions updateOptions = FindAndModifyOptions.options().upsert(false).returnNew(true);

    private void updateAllWithFilterReason(OfferMetaData offerMetaData, String filterReason) {
        final Criteria criteria = Criteria
                .where("importId").is(offerMetaData.getImportId())
                .and("uniqueKey").is(offerMetaData.getUniqueKey());

        final Update update = Update.update("filterReason", filterReason);


        final WriteResult writeResult = mongoTemplate.updateMulti(Query.query(criteria), update, OfferMetaData.class);

        LOG.info("updated:{}", writeResult.getN());

//        mongoTemplate.findAndModify(Query.query(criteria), update, updateOptions, OfferMetaData.class);
    }

    public void removeOlderImports(String importId) {
        final Criteria criteria = Criteria
                .where("importId").ne(importId);
        mongoTemplate.remove(Query.query(criteria), OfferMetaData.class);
    }


}
