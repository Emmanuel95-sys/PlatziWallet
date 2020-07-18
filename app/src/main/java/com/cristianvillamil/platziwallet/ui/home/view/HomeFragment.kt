package com.cristianvillamil.platziwallet.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_ERROR
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.cristianvillamil.platziwallet.ui.observable.AvailableBalanceObservable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter = FavoriteTransferAdapter()


    //creando isntancia del observable
    private val availableBalanceObservable = AvailableBalanceObservable()
    //creando una instancia del presentador en la vista.
    private var homePresenter : HomeContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this)
        //si no es nulo llama al metodo.
        homePresenter?.retrieveFavoriteTransfers()
        circularProgress.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)

        availableBalanceObservable.addObserver(object:
            com.cristianvillamil.platziwallet.ui.observable.CustomObserver {
            //por medio de este metodo nos llegara el nuevo valor
            override fun notifyChange(newValue: Double) {
                //cuando el evento notifique
                //nuestro texto va a cambiar a ese nuevo valor
                //lo hara pomedio del observer que se suscribio por medio de addObserver
                //al observable de available balance
                amountValueTextView.text = ("$ $newValue")
            }
        })
        //no podemos acceder directmente
        //hay que agregar la firma delmetodo en la interfaz
        //nos suscribimos por medio del observe
        homePresenter!!.getPercentageLiveData().observe(this, androidx.lifecycle.Observer<String> {
            value -> percentageText.text = value
        })

    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter
    }

    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeLoader.visibility = View.GONE
    }

    override fun showFavoriteTransfers(favoriteTransfers: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfers)
        //se encarga de manejar las instancias de la factoria.
        val dialogFactory = MessageFactory()
        context?.let {
           val errorDialog =  dialogFactory.getDialog(it, TYPE_ERROR)
            errorDialog.show()
        }


    }
}