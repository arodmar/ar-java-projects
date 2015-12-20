<!DOCTYPE html>
<html lang="en-US" ng-app="gemStore">
    
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<script type="text/javascript" src="angular.min.js"></script>
<script type="text/javascript" src="app.js" ></script>


<body ng-controller="StoreController as store">

    <div class="product row" ng-repeat="product in store.products">
        <h1>{{product.name}}</h1>
        <h2>{{product.price |currency}}</h2>
        <p>{{product.description}}</p>
        
        <section ng-show="product.images.length">
        <img ng-src="{{product.images[0]}}" />
        <ul class="list-inline thumbs">
          <li class="thumbnail" ng-repeat="image in product.images">
            <img ng-src="{{image}}" />
          </li>
        </ul>
      </section>
       
        
           <section class="tab" ng-controller="TabController as tab">
        <ul class="nav nav-pills">
          <li ng-class="{active:tab.isSet(1)}">
            <a href ng-click="tab.setTab(1)">Description</a></li>
          <li ng-class="{active:tab.isSet(2)}">
            <a href ng-click="tab.setTab(2)">Specs</a></li>
          <li ng-class="{active:tab.isSet(3)}">
            <a href ng-click="tab.setTab(3)">Reviews</a></li>
        </ul>
        <div ng-show="tab.isSet(1)">
          <h4>Description</h4>
          <blockquote>{{product.description}}</blockquote>
        </div>
        <div ng-show="tab.isSet(2)">
          <h4>Specs</h4>
          <blockquote>Shine: {{product.shine}}</blockquote>
        </div>
        <div ng-show="tab.isSet(3)">
          <h4>Reviews</h4>
          <blockquote></blockquote>
        </div>
      </section>
        
        <button ng-show="store.product.canPurchase">Add to Cart</button>

</div>

</body>
</html>