Extending the CQ Hybris connector
========

This project shows how to extend/customize the Hybris connector to achieve the following:
* parse some custom Hybris data when importing products from Hybris: `MyResponseParser#parseProductData`
* add/update some specific product attributes in CQ when importing products from Hybris: `MyImportHandler#updateProduct`
* modify the way assets are stored in CQ when importing products from Hybris: `MyImportHandler#updateAsset`
* customize the way catalogs are imported/updated from Hybris: `MyImporter#importCatalog`
* customize the way groups are imported from Hybris: `MyImporter#importGroups`
* customize the catalog/product rollout process: `MyCommerceService#catalogRolloutHook` and `MyCommerceService#productRolloutHook`
* change the price of a product: `MyCommerceSession#getProductPrice`

Some other extension points:
* `HybrisFactory#getProduct` is responsible for creating Product instances.
* `HybrisSession#getProductPriceInfo` is responsible for getting the correct price for a product for the current user.
* `HybrisService#login` is responsible for extracting SessionInfo from a request.
* `HybrisFactory#getSession` is responsible for creating HybrisSession instances.
* `ProfileSynchronizer#syncProfile` is responsible for syncing the user’s CQ profile to the respective Hybris account.
* `HybrisConnection` is responsible for actually sending HTTP(S) requests to the Hybris server.
* `HybrisAuthenticationHandler`(s) are responsible for authenticating HTTP(S) requests.
