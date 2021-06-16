<h2>Summary</h2>
Not much thing to write right now 

<h2>Technical Details:</h2>
<ul>
<li>Also components named with this pattern &lt;LAYOUT_XML_NAME&gt;_&lt;COMPONENT_SHORT_NAME&gt;_&lt;FIELD_NAME&gt; for example =&gt; activity_main_et_username
<ul>
<li>Button - btn</li>
<li>EditText - et</li>
<li>RecyclerView - rv</li>
</ul>
</li>
<li>For class namings used <b>UpperCamelCase</b> and for the resources namings used <b>SnakeCase</b></li>
<li>I've separated Util classes, so it's easier to maintain & bug-fix & improve and it's better for principles</li>
<li>I've also separated data classes cause of in Kotlin data classes inheritance is a bit problematic</li>
<li>Separated with Request and Response model even if they are same according to SOLID principles</li>
<li>You can ask like why you used DI for request model, I wanted to make sure won't create instance for every call also will modify data before ApiCall</li>
<li>Inside ViewModel's I've used .postValue instead of x.value = response.body  cause of postValue is for background thread</li>
</ul>


<h2>3rd Party Libraries</h2>
<ul>
<li><b>Retrofit:</b> Will be added for API calls </li> 
<li><b>GSON:</b> Will be added for serializing API response from Retrofit</li>
<li><b>SwipeRefreshLayout:</b> Might be good for recalling data without button or resetting lifecycle </li>
<li><b>RxJava & RxAndroid:</b> Might be good for reactive programming </li>
</ul>


<h2>Technical Stuff</h2>
<ul>
<li><b>minSdkVersion:</b> 23 </li>
<li><b>targetSdkVersion:</b> 30 (Android 11) </li>
<li><b>versionCode:</b> 1 </li>
<li><b>versionName:</b> 1.0 </li>
<li><b>Type Of Layouts Used:</b> ConstraintLayout </li>
</ul>


<h2>Commit History</h2>
<ul>
<li><b>Last Commit:</b> QueryRepository created & DataBinding arranged for QueryActivity.kt & Strings.xml modified & QueryApi created and modified & QueryRequest created (For Sample will modify later </li>
<li><b>32c01e2:</b> Added comments for more specified info & ViewModel added loading and isSuccess situations & Constants separated for easier to find & QueryApi Headers modified for Bearer Authentication & Error handled for API response & AppModule migrated new SerializationUtil & ErrorResponse model added & Added comment to IntentUtil &</li>
<li><b>5f01e59:</b> AndroidManifest.xml modified for new activity & QueryActivity.kt added & IntentUtil created & Inside IntentUtil methods are overloaded & Models for QueryApi generated  & ApiEndpoints for QueryApi modified & </li>
<li><b>51c4aa2:</b> activity_main.xml modified & bg_login_btn.xml added & colors.xml modified and also colors.xml added for night version & InputUtil.kt created and provided in AppModule & MainActivity.kt modified re-arranged  </li>
<li><b>adfafe0:</b> styles.xml added & activity_main.xml modified & In MainActivity.kt modified and added observers & AppModule modified to reach to token from anywhere & Syntax bugs fixed </li>
<li><b>a7775d7:</b> Constants created & AuthenticationRepository created for authentication api call & AppModule modified & AuthRequest modified with default values from Constants to prevent null values & NetworkUtil created for internet check & MainActivity.kt modified for NetworkUtil</li>
<li><b>e9824bc:</b> BindingAdapter.kt added for Data Binding & Models totally modified  & Constants added & AuthResponse.kt created</li>
<li><b>2451d52:</b> InternetAccess added to Manifest & ApiConstants created & AppModule modified for QueryApi and AuthenticationApi & Base model created for request </li>
<li><b>4cf97be:</b> Retrofit and GSON added for API communication & SwipeRefreshLayout Added & Coroutines added </li>
<li><b>be904df:</b> Hilt added for Dependency Injection &  AppModule generated from SingletonComponent::class & Class extended from Application for DI & MainActivity marked as AndroidEntryPoint & AndroidManifest.xml and build.gradle's modified for DI</li>
<li><b>6dd8e9e:</b> Gradle upgraded to 4.2.1 & jCenter() removed & viewBinding and dataBinding enabled  </li>
<li><b>44fbd06:</b> Initial Commit & jCenter removed cause will be shut down in the future & README.md added and added to-do libraries </li>
</ul>
