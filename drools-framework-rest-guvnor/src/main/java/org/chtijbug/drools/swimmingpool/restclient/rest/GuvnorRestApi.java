package org.chtijbug.drools.swimmingpool.restclient.rest;


import org.drools.guvnor.server.jaxrs.jaxb.Asset;
import retrofit.http.*;

import java.util.Collection;
import java.util.List;

public interface GuvnorRestApi {

    @GET("/rest/packages/{organizationalUnitName}/{repositoryName}")
    @Headers({"Accept: application/json"})
    List<Package> getAllPackages(@Path("organizationalUnitName") String organizationalUnitName, @Path("repositoryName") String repositoryName);

    @GET("/rest/packages/{organizationalUnitName}/{repositoryName}/{packageName}/assets")
    @Headers({"Accept: application/json"})
    List<Asset> getAllAssets(@Path("organizationalUnitName") String organizationalUnitName, @Path("repositoryName") String repositoryName, @Path("packageName") String packageName);

    @GET("/rest/packages/{organizationalUnitName}/{repositoryName}/{packageName}/assets/{assetName}")
    @Headers({"Accept: application/json"})
    Collection<Asset> getAsset(@Path("organizationalUnitName") String organizationalUnitName, @Path("repositoryName") String repositoryName, @Path("packageName") String packageName, @Path("assetName") String assetName);

    @PUT("/rest/packages/{organizationalUnitName}/{repositoryName}/{packageName}/asset/{assetName}")
    void updateAsset(@Path("organizationalUnitName") String organizationalUnitName, @Path("repositoryName") String repositoryName, @Path("packageName") String packageName, @Path("assetName") String assetName, @Body Asset asset);

    @PUT("/rest/packages/{organizationalUnitName}/{repositoryName}/{packageName}/newAsset")
    @Headers({"Accept: application/json"})
    void createAsset(@Path("organizationalUnitName") String organizationalUnitName, @Path("repositoryName") String repositoryName, @Path("packageName") String packageName, @Body Asset asset);

    @PUT("/rest/packages/{organizationalUnitName}/{repositoryName}/{packageName}/asset/{assetName}/source")
    @Headers({"Accept: application/json"})
    void updateAssetFromSource(@Path("organizationalUnitName") String organizationalUnitName, @Path("repositoryName") String repositoryName, @Path("packageName") String packageName, @Path("assetName") String assetName, @Body String content);


}
