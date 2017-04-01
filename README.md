# GloseRedux

Gallery of book application to see how redux architecture works on a real application on android with kotlin.

# Packges

Packages are organized by feature, overall class are in the 'common' feature as redux class.
Business logic, models, belong to domain
Adapters, Activity, etc, belong to ui

# Redux

We have a <b>AppState</b> that know all applications, it composed by states of all features (only GalleryState in demo).
Same for reducer we have one reducer by feature, they are regrouped in <b>AppStateReducer</b> which we call the method reduce on each reducer (only one actualy(GalleryReducer)).
Webservice are called through Middleware, we can have one or more middleware by feature, they are composed in <b>AppStateMiddleware</b>.
To update the view when the state changes we need to register them in <b>Store</b>. For instance, to update a list of item, we call subscribe when the view and the adapter are instancied :
<code>
Application.sStore.subscribe(Runnable {
            runOnUiThread {
                galleryAdapter.updateData(Application.sStore.state.mGalleryState.books)
            }
        }
</code>



