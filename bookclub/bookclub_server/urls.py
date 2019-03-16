from django.contrib import admin
from django.urls import path, include
from . import usercontroller, wishlistcontroller
urlpatterns = [
    # usercontroller
    path('login/', usercontroller.login),
    path('signup/', usercontroller.signup),
    path('forgotPassword/', usercontroller.forgot_password),
    path('signout/', usercontroller.sign_out),
    path('getSession/', usercontroller.get_session),
    path('confirmMatch/', usercontroller.confirm_match),
    path('rejectMatch/', usercontroller.reject_match),
    path('seeOtherUserProfile/', usercontroller.see_other_user_profile),
    path('matchListIndex/', usercontroller.match_list_index),
    path('suggestionListIndex/', usercontroller.suggestion_list_index),
    path('mainMenuIndex/', usercontroller.main_menu_index),
    path('searchIndex/', usercontroller.search_index),
    # wishlistcontroller
    path('wishlist/index/', wishlistcontroller.index),
    path('wishlist/delete/', wishlistcontroller.delete),
    path('wishlist/add/', wishlistcontroller.add)
    # wishlist/update olacak mi?
    # wishlist/drag olacak mi?
]
