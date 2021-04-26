<map version="freeplane 1.7.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="Ejercicio1" FOLDED="false" ID="ID_1321435700" CREATED="1619447787440" MODIFIED="1619456584752" STYLE="oval">
<font SIZE="18"/>
<hook NAME="MapStyle" zoom="1.5">
    <properties edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff" fit_to_viewport="false"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ICON_SIZE="12.0 pt" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="10.0 pt" SHAPE_VERTICAL_MARGIN="10.0 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,11"/>
</stylenode>
</stylenode>
</map_styles>
</hook>
<hook NAME="AutomaticEdgeColor" COUNTER="9" RULE="ON_BRANCH_CREATION"/>
<node TEXT="A1" POSITION="left" ID="ID_1818241210" CREATED="1619456124624" MODIFIED="1619456589086">
<edge COLOR="#007c00"/>
<node TEXT="Crear array" ID="ID_98626872" CREATED="1619447801708" MODIFIED="1619456124634">
<font BOLD="true"/>
</node>
<node TEXT="Rellenar elementos" ID="ID_459838969" CREATED="1619447815151" MODIFIED="1619456124641">
<font BOLD="true"/>
<node TEXT="Contar de 0 a 4 en i" ID="ID_313369983" CREATED="1619455310353" MODIFIED="1619455374572">
<node TEXT="Mostrar &quot;Introduce un n&#xfa;mero&quot;" ID="ID_674802310" CREATED="1619455316902" MODIFIED="1619455329492"/>
<node TEXT="Pedir el n&#xfa;mero por teclado" ID="ID_1925973729" CREATED="1619455329687" MODIFIED="1619455333962"/>
<node TEXT="Almacenar el valor en la posici&#xf3;n i del array" ID="ID_1285844344" CREATED="1619455337188" MODIFIED="1619455364843"/>
</node>
</node>
<node TEXT="Calcular media" ID="ID_662242138" CREATED="1619447822353" MODIFIED="1619456124650">
<font BOLD="true"/>
<node TEXT="Calcular suma" ID="ID_1753831982" CREATED="1619455410319" MODIFIED="1619455449654">
<font BOLD="true"/>
<node TEXT="suma = 0" ID="ID_1598261561" CREATED="1619455468674" MODIFIED="1619455470757"/>
<node TEXT="Por cada dato" ID="ID_267849343" CREATED="1619455456236" MODIFIED="1619455868187">
<node TEXT="suma = suma + dato" ID="ID_16575430" CREATED="1619455471408" MODIFIED="1619455870936"/>
</node>
</node>
<node TEXT="media = suma / 5" ID="ID_1319236859" CREATED="1619455428175" MODIFIED="1619455489453"/>
</node>
<node TEXT="Calcular nota m&#xe1;s alta" ID="ID_1332292719" CREATED="1619455226027" MODIFIED="1619456124656">
<font BOLD="true"/>
<node TEXT="alta = array[0]" ID="ID_1007688887" CREATED="1619455528673" MODIFIED="1619455537605"/>
<node TEXT="Por cada dato" ID="ID_1527713102" CREATED="1619455490784" MODIFIED="1619455881754">
<node TEXT="Si dato &gt; alta" ID="ID_1077446984" CREATED="1619455540015" MODIFIED="1619456003359">
<node TEXT="alta = dato" ID="ID_819610019" CREATED="1619455551734" MODIFIED="1619455885119"/>
</node>
</node>
</node>
<node TEXT="Calcular nota m&#xe1;s baja" ID="ID_1782640464" CREATED="1619455230707" MODIFIED="1619456124661">
<font BOLD="true"/>
<node TEXT="baja = array[0]" ID="ID_1721520921" CREATED="1619455528673" MODIFIED="1619455571341"/>
<node TEXT="Por cada dato" ID="ID_1463124658" CREATED="1619455490784" MODIFIED="1619455893747">
<node TEXT="Si dato &lt; baja" ID="ID_335276170" CREATED="1619455540015" MODIFIED="1619456009213">
<node TEXT="baja = dato" ID="ID_447429748" CREATED="1619455551734" MODIFIED="1619455896962"/>
</node>
</node>
</node>
<node TEXT="Mostrar resultados" ID="ID_1058610116" CREATED="1619455586296" MODIFIED="1619456124664">
<font BOLD="true"/>
</node>
</node>
<node TEXT="A2" POSITION="left" ID="ID_833813538" CREATED="1619456124624" MODIFIED="1619456591235">
<edge COLOR="#007c00"/>
<node TEXT="Crear array" ID="ID_1347447348" CREATED="1619447801708" MODIFIED="1619456124634">
<font BOLD="true"/>
</node>
<node TEXT="Rellenar elementos" ID="ID_1579246757" CREATED="1619447815151" MODIFIED="1619456124641">
<font BOLD="true"/>
<node TEXT="Contar de 0 a 4 en i" ID="ID_911917206" CREATED="1619455310353" MODIFIED="1619455374572">
<node TEXT="Mostrar &quot;Introduce un n&#xfa;mero&quot;" ID="ID_644928903" CREATED="1619455316902" MODIFIED="1619455329492"/>
<node TEXT="Pedir el n&#xfa;mero por teclado" ID="ID_1388847088" CREATED="1619455329687" MODIFIED="1619455333962"/>
<node TEXT="Almacenar el valor en la posici&#xf3;n i del array" ID="ID_1564259960" CREATED="1619455337188" MODIFIED="1619455364843"/>
</node>
</node>
<node TEXT="Calcular todo" ID="ID_1177054644" CREATED="1619447822353" MODIFIED="1619456218533">
<font BOLD="true"/>
<node TEXT="suma = 0" ID="ID_25429592" CREATED="1619455468674" MODIFIED="1619455470757"/>
<node TEXT="alta = array[0]" ID="ID_363901312" CREATED="1619455528673" MODIFIED="1619455537605"/>
<node TEXT="baja = array[0]" ID="ID_1889167504" CREATED="1619455528673" MODIFIED="1619455571341"/>
<node TEXT="Por cada dato" ID="ID_683056850" CREATED="1619455456236" MODIFIED="1619455868187">
<node TEXT="suma = suma + dato" ID="ID_161091659" CREATED="1619455471408" MODIFIED="1619455870936"/>
<node TEXT="Si dato &gt; alta" ID="ID_1504652298" CREATED="1619455540015" MODIFIED="1619456003359">
<node TEXT="alta = dato" ID="ID_1728300234" CREATED="1619455551734" MODIFIED="1619455885119"/>
</node>
<node TEXT="Si dato &lt; baja" ID="ID_1818971271" CREATED="1619455540015" MODIFIED="1619456009213">
<node TEXT="baja = dato" ID="ID_1380759856" CREATED="1619455551734" MODIFIED="1619455896962"/>
</node>
</node>
<node TEXT="media = suma / 5" ID="ID_1475341505" CREATED="1619455428175" MODIFIED="1619455489453"/>
</node>
<node TEXT="Mostrar resultados" ID="ID_1446231506" CREATED="1619455586296" MODIFIED="1619456124664">
<font BOLD="true"/>
</node>
</node>
<node TEXT="B" POSITION="right" ID="ID_1542079182" CREATED="1619456594558" MODIFIED="1619456597617">
<edge COLOR="#7c007c"/>
<node TEXT="Repetir hasta opcion = 3" ID="ID_713875872" CREATED="1619456667833" MODIFIED="1619456702227">
<node TEXT="Mostrar men&#xfa;" ID="ID_1018363389" CREATED="1619456635787" MODIFIED="1619456639119">
<node TEXT="Mostrar" ID="ID_640421045" CREATED="1619456647244" MODIFIED="1619456649558">
<node TEXT="1. Calcular letra DNI" ID="ID_1199442814" CREATED="1619456610413" MODIFIED="1619456690705"/>
<node TEXT="2. Calcular medida de cm a pulgadas" ID="ID_796457663" CREATED="1619456617586" MODIFIED="1619456693505"/>
<node TEXT="3. Salir" ID="ID_387231441" CREATED="1619456633220" MODIFIED="1619456696477"/>
</node>
</node>
<node TEXT="Introducir opcion" ID="ID_511021939" CREATED="1619456711610" MODIFIED="1619456717465"/>
<node TEXT="Seg&#xfa;n opcion" ID="ID_1186329431" CREATED="1619456722362" MODIFIED="1619456728975">
<node TEXT="1" OBJECT="java.lang.Long|1" ID="ID_1245195275" CREATED="1619456729377" MODIFIED="1619456730265">
<node TEXT="Pedir numero DNI" ID="ID_148635823" CREATED="1619456766331" MODIFIED="1619456769956"/>
<node TEXT="Crear lista de letras" ID="ID_186212948" CREATED="1619456739707" MODIFIED="1619456751252"/>
<node TEXT="Calcular resto numero entre 23" ID="ID_1927636406" CREATED="1619456755400" MODIFIED="1619456793106"/>
<node TEXT="Calcular letra seg&#xfa;n resto" ID="ID_919629522" CREATED="1619456779756" MODIFIED="1619456784705"/>
<node TEXT="Mostrar letra" ID="ID_355928662" CREATED="1619456903455" MODIFIED="1619456906900"/>
</node>
<node TEXT="2" OBJECT="java.lang.Long|2" ID="ID_399723335" CREATED="1619456730482" MODIFIED="1619456731062">
<node TEXT="Pedir cm" ID="ID_1999512329" CREATED="1619456844055" MODIFIED="1619456848608"/>
<node TEXT="pulgadas = cm / 2,54" ID="ID_1092384449" CREATED="1619456848774" MODIFIED="1619456893040"/>
<node TEXT="Mostrar pulgadas" ID="ID_334036409" CREATED="1619456898401" MODIFIED="1619456902570"/>
</node>
<node TEXT="3" OBJECT="java.lang.Long|3" ID="ID_1234731771" CREATED="1619456731337" MODIFIED="1619456731716">
<node TEXT="Mostrar gracias por su visita" ID="ID_643432413" CREATED="1619456909261" MODIFIED="1619456924761"/>
</node>
<node TEXT="Otro" ID="ID_199316485" CREATED="1619457429477" MODIFIED="1619457431061">
<node TEXT="Mostrar no existe esa opci&#xf3;n" ID="ID_1830751084" CREATED="1619457431335" MODIFIED="1619457435602"/>
</node>
</node>
</node>
</node>
</node>
</map>
