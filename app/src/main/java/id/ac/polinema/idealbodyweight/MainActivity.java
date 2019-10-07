package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BmiFragment;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener
		, BrocaIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener,
		BmiFragment.OnFragmentInteractionListener{
	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	private BmiFragment bmiFragment;
	// Deklarasikan atribut Fragment di sini

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Muhammad Nizar Firmansyah");
		menuFragment = new MenuFragment();
		brocaIndexFragment = new BrocaIndexFragment();
		resultFragment = new ResultFragment();
		bmiFragment = new BmiFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini

		if (item.getItemId() == R.id.menu_about) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		resultFragment.setStatus("1");
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}
	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		if (tag.equalsIgnoreCase("1")) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, brocaIndexFragment)
					.commit();
		}else if(tag.equalsIgnoreCase("2")){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bmiFragment)
					.commit();
		}
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bmiFragment)
				.commit();
	}

	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {

	}

	@Override
	public void onCalculateBmiIndexClicked(float index) {
		resultFragment.setInformation("The Body Mass Index is   "+Math.round(index)+"kg/m2");
		resultFragment.setStatus("2");
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}
}
