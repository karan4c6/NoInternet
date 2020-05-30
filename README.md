# Observe Internet Connectivity in View Layer using LiveData

Wrapping Network Connection into a LiveData object which can be observed by the View Layer.

Display a Dialog box / Update ui when no internet connectivity changes.

Keeping in mind that activeNetworkInfo.type is deprecated in API level 28, this solution uses, ConnectivityManager.NetworkCallback API

![Demo](/extras/no_internet.gif)
