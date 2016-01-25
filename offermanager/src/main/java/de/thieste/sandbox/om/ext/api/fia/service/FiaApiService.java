package de.thieste.sandbox.om.ext.api.fia.service;

import de.thieste.sandbox.om.ext.api.fia.bean.FiaPage;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by thieste on 22.12.15.
 */
public class FiaApiService {


    private final Map<Integer, FiaPage> fiaPageMap;

    public FiaApiService(List<FiaPage> fiaPageList) {
        fiaPageMap = fiaPageList
                .stream()
                .collect(Collectors.toMap(FiaPage::getPageNumber, (f) -> f));
    }

    public Optional<FiaPage> getNextPage(int page) {
        return Optional.ofNullable(fiaPageMap.get(page));
    }


}
