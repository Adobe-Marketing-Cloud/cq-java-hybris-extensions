Extending the CQ Hybris connector
========

This project shows how to extend/customize the hybris connector to achieve the following:
* parse some custom hybris data when importing products from Hybris
	`com.mycompany.myproject.commerce.MyResponseParser#parseProductData`
* add/update some specific product attributes in CQ when importing products from Hybris
	`com.mycompany.myproject.commerce.MyImportHandler#updateProduct`
* modify the way assets are stored in CQ when importing products from Hybris
	`com.mycompany.myproject.commerce.MyImportHandler#updateAsset`
* customize the way catalogs are imported/updated from Hybris
	`com.mycompany.myproject.commerce.MyImporter#importCatalog`
* customize the way groups are imported from Hybris
	`com.mycompany.myproject.commerce.MyImporter#importGroups`
* customize the catalog/product rollout process
	`com.adobe.cq.commerce.hybris.common.DefaultHybrisService#catalogRolloutHook`
	`com.adobe.cq.commerce.hybris.common.DefaultHybrisService#productRolloutHook`
* change the price of a product
	`com.mycompany.myproject.commerce.MyCommerceSession#getProductPrice`

Some other extension points:
* `HybrisFactory#getProduct` is responsible for creating Product instances
* `HybrisSession#getProductPriceInfo` is responsible for getting the correct price for a product for the current user
* `HybrisService#login` is responsible for extracting SessionInfo from a request
* `HybrisFactory#getSession` is responsible for creating HybrisSession instances
* `ProfileSynchronizer#syncProfile` is responsible for syncing the user’s CQ profile to the respective hybris account
* `HybrisConnection` is responsible for actually sending HTTP(S) requests to the Hybrisserver
* `HybrisAuthenticationHandler`(s) are responsible for authenticating HTTP(S) requests.
