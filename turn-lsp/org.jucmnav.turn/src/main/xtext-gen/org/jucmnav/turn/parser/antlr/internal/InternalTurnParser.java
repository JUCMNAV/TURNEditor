package org.jucmnav.turn.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.jucmnav.turn.services.TurnGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTurnParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'urnModel'", "'showAsMeansEnd'", "'{'", "'description'", "'author'", "'created'", "'modified'", "'version'", "'urnVersion'", "'}'", "'concern'", "':'", "','", "'['", "']'", "'link'", "'type'", "'-->'", "'metadata'", "'='", "'#'", "'@'", "'!'", "'%'", "'&'", "'*'", "'.'", "'actor'", "'importance'", "'unit'", "'contributesTo'", "'correlated'", "'with'", "'decomposes'", "'dependsOn'", "'strategiesGroup'", "'strategy'", "'includes'", "'exceeding'", "'evaluation'", "'convertedWith'", "'real'", "'linearConversion'", "'target'", "'threshold'", "'worst'", "'mappingConversion'", "'contributionContextGroup'", "'contributionContext'", "'-'", "'+'", "'singleton'", "'map'", "'start'", "'catches'", "'[['", "']]'", "';'", "'in'", "'->'", "'X'", "'join'", "'synch'", "'sync'", "'|'", "'wait'", "'timer'", "'timeout'", "'trigger'", "'fail'", "'end'", "'or'", "'[else]'", "'and'", "'stub'", "'('", "')'", "'out'", "'replication'", "'protected'", "'..'", "'scenarioGroup'", "'scenario'", "'pre'", "'post'", "'initialize'", "'enum'", "'denied'", "'weaklyDenied'", "'weaklySatisfied'", "'satisfied'", "'conflict'", "'unknown'", "'none'", "'softgoal'", "'goal'", "'task'", "'resource'", "'belief'", "'indicator'", "'make'", "'help'", "'somePositive'", "'someNegative'", "'hurt'", "'break'", "'high'", "'medium'", "'low'", "'xor'", "'persistent'", "'transient'", "'team'", "'object'", "'process'", "'agent'", "'parent'", "'abort'", "'failure'", "'synchronizing'", "'blocking'", "'bool'", "'int'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalTurnParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTurnParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTurnParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTurn.g"; }



     	private TurnGrammarAccess grammarAccess;

        public InternalTurnParser(TokenStream input, TurnGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "URNspec";
       	}

       	@Override
       	protected TurnGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleURNspec"
    // InternalTurn.g:65:1: entryRuleURNspec returns [EObject current=null] : iv_ruleURNspec= ruleURNspec EOF ;
    public final EObject entryRuleURNspec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURNspec = null;


        try {
            // InternalTurn.g:65:48: (iv_ruleURNspec= ruleURNspec EOF )
            // InternalTurn.g:66:2: iv_ruleURNspec= ruleURNspec EOF
            {
             newCompositeNode(grammarAccess.getURNspecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURNspec=ruleURNspec();

            state._fsp--;

             current =iv_ruleURNspec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURNspec"


    // $ANTLR start "ruleURNspec"
    // InternalTurn.g:72:1: ruleURNspec returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) ) ;
    public final EObject ruleURNspec() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_showAsMeansEnd_5_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_info_3_0 = null;

        EObject lv_actors_4_0 = null;

        EObject lv_stratGroups_6_0 = null;

        EObject lv_strategies_7_0 = null;

        EObject lv_indConversions_8_0 = null;

        EObject lv_contribContextGroups_9_0 = null;

        EObject lv_contribContexts_10_0 = null;

        EObject lv_ucmMaps_11_0 = null;

        EObject lv_scenGroups_12_0 = null;

        EObject lv_scenDefs_13_0 = null;

        EObject lv_variables_14_0 = null;

        EObject lv_enumTypes_15_0 = null;

        EObject lv_concerns_16_0 = null;

        EObject lv_urnlinks_17_0 = null;

        EObject lv_metadata_18_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) ) )
            // InternalTurn.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) )
            {
            // InternalTurn.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) )
            // InternalTurn.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) )
            {
            // InternalTurn.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) )
            // InternalTurn.g:81:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getURNspecAccess().getUnorderedGroup());
            			
            // InternalTurn.g:84:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?)
            // InternalTurn.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?
            {
            // InternalTurn.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=17;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // InternalTurn.g:86:3: ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) )
            	    {
            	    // InternalTurn.g:86:3: ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) )
            	    // InternalTurn.g:87:4: {...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalTurn.g:87:101: ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) )
            	    // InternalTurn.g:88:5: ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalTurn.g:91:8: ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) )
            	    // InternalTurn.g:91:9: {...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    }
            	    // InternalTurn.g:91:18: (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? )
            	    // InternalTurn.g:91:19: otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )?
            	    {
            	    otherlv_1=(Token)match(input,11,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getURNspecAccess().getUrnModelKeyword_0_0());
            	    							
            	    // InternalTurn.g:95:8: ( (lv_name_2_0= ruleQualifiedName ) )
            	    // InternalTurn.g:96:9: (lv_name_2_0= ruleQualifiedName )
            	    {
            	    // InternalTurn.g:96:9: (lv_name_2_0= ruleQualifiedName )
            	    // InternalTurn.g:97:10: lv_name_2_0= ruleQualifiedName
            	    {

            	    										newCompositeNode(grammarAccess.getURNspecAccess().getNameQualifiedNameParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_name_2_0=ruleQualifiedName();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.jucmnav.turn.Turn.QualifiedName");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalTurn.g:114:8: ( (lv_info_3_0= ruleConcreteURNspec ) )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==13) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalTurn.g:115:9: (lv_info_3_0= ruleConcreteURNspec )
            	            {
            	            // InternalTurn.g:115:9: (lv_info_3_0= ruleConcreteURNspec )
            	            // InternalTurn.g:116:10: lv_info_3_0= ruleConcreteURNspec
            	            {

            	            										newCompositeNode(grammarAccess.getURNspecAccess().getInfoConcreteURNspecParserRuleCall_0_2_0());
            	            									
            	            pushFollow(FOLLOW_4);
            	            lv_info_3_0=ruleConcreteURNspec();

            	            state._fsp--;


            	            										if (current==null) {
            	            											current = createModelElementForParent(grammarAccess.getURNspecRule());
            	            										}
            	            										set(
            	            											current,
            	            											"info",
            	            											lv_info_3_0,
            	            											"org.jucmnav.turn.Turn.ConcreteURNspec");
            	            										afterParserOrEnumRuleCall();
            	            									

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTurn.g:139:3: ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) )
            	    {
            	    // InternalTurn.g:139:3: ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) )
            	    // InternalTurn.g:140:4: {...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalTurn.g:140:101: ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ )
            	    // InternalTurn.g:141:5: ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalTurn.g:144:8: ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==38) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalTurn.g:144:9: {...}? => ( (lv_actors_4_0= ruleActor ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:144:18: ( (lv_actors_4_0= ruleActor ) )
            	    	    // InternalTurn.g:144:19: (lv_actors_4_0= ruleActor )
            	    	    {
            	    	    // InternalTurn.g:144:19: (lv_actors_4_0= ruleActor )
            	    	    // InternalTurn.g:145:9: lv_actors_4_0= ruleActor
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getActorsActorParserRuleCall_1_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_actors_4_0=ruleActor();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"actors",
            	    	    										lv_actors_4_0,
            	    	    										"org.jucmnav.turn.Turn.Actor");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTurn.g:167:3: ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) )
            	    {
            	    // InternalTurn.g:167:3: ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) )
            	    // InternalTurn.g:168:4: {...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalTurn.g:168:101: ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) )
            	    // InternalTurn.g:169:5: ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalTurn.g:172:8: ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) )
            	    // InternalTurn.g:172:9: {...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    }
            	    // InternalTurn.g:172:18: ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) )
            	    // InternalTurn.g:172:19: (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' )
            	    {
            	    // InternalTurn.g:172:19: (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' )
            	    // InternalTurn.g:173:9: lv_showAsMeansEnd_5_0= 'showAsMeansEnd'
            	    {
            	    lv_showAsMeansEnd_5_0=(Token)match(input,12,FOLLOW_4); 

            	    									newLeafNode(lv_showAsMeansEnd_5_0, grammarAccess.getURNspecAccess().getShowAsMeansEndShowAsMeansEndKeyword_2_0());
            	    								

            	    									if (current==null) {
            	    										current = createModelElement(grammarAccess.getURNspecRule());
            	    									}
            	    									setWithLastConsumed(current, "showAsMeansEnd", true, "showAsMeansEnd");
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTurn.g:190:3: ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) )
            	    {
            	    // InternalTurn.g:190:3: ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) )
            	    // InternalTurn.g:191:4: {...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalTurn.g:191:101: ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ )
            	    // InternalTurn.g:192:5: ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalTurn.g:195:8: ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==46) ) {
            	            int LA3_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt3=1;
            	            }


            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalTurn.g:195:9: {...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:195:18: ( (lv_stratGroups_6_0= ruleStrategiesGroup ) )
            	    	    // InternalTurn.g:195:19: (lv_stratGroups_6_0= ruleStrategiesGroup )
            	    	    {
            	    	    // InternalTurn.g:195:19: (lv_stratGroups_6_0= ruleStrategiesGroup )
            	    	    // InternalTurn.g:196:9: lv_stratGroups_6_0= ruleStrategiesGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getStratGroupsStrategiesGroupParserRuleCall_3_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_stratGroups_6_0=ruleStrategiesGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"stratGroups",
            	    	    										lv_stratGroups_6_0,
            	    	    										"org.jucmnav.turn.Turn.StrategiesGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalTurn.g:218:3: ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) )
            	    {
            	    // InternalTurn.g:218:3: ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) )
            	    // InternalTurn.g:219:4: {...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalTurn.g:219:101: ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ )
            	    // InternalTurn.g:220:5: ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalTurn.g:223:8: ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==47) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalTurn.g:223:9: {...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:223:18: ( (lv_strategies_7_0= ruleEvaluationStrategy ) )
            	    	    // InternalTurn.g:223:19: (lv_strategies_7_0= ruleEvaluationStrategy )
            	    	    {
            	    	    // InternalTurn.g:223:19: (lv_strategies_7_0= ruleEvaluationStrategy )
            	    	    // InternalTurn.g:224:9: lv_strategies_7_0= ruleEvaluationStrategy
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getStrategiesEvaluationStrategyParserRuleCall_4_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_strategies_7_0=ruleEvaluationStrategy();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"strategies",
            	    	    										lv_strategies_7_0,
            	    	    										"org.jucmnav.turn.Turn.EvaluationStrategy");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalTurn.g:246:3: ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) )
            	    {
            	    // InternalTurn.g:246:3: ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) )
            	    // InternalTurn.g:247:4: {...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalTurn.g:247:101: ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ )
            	    // InternalTurn.g:248:5: ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalTurn.g:251:8: ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==53) ) {
            	            int LA5_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt5=1;
            	            }


            	        }
            	        else if ( (LA5_0==57) ) {
            	            int LA5_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalTurn.g:251:9: {...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:251:18: ( (lv_indConversions_8_0= ruleIndicatorConversion ) )
            	    	    // InternalTurn.g:251:19: (lv_indConversions_8_0= ruleIndicatorConversion )
            	    	    {
            	    	    // InternalTurn.g:251:19: (lv_indConversions_8_0= ruleIndicatorConversion )
            	    	    // InternalTurn.g:252:9: lv_indConversions_8_0= ruleIndicatorConversion
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getIndConversionsIndicatorConversionParserRuleCall_5_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_indConversions_8_0=ruleIndicatorConversion();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"indConversions",
            	    	    										lv_indConversions_8_0,
            	    	    										"org.jucmnav.turn.Turn.IndicatorConversion");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTurn.g:274:3: ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) )
            	    {
            	    // InternalTurn.g:274:3: ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) )
            	    // InternalTurn.g:275:4: {...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6)");
            	    }
            	    // InternalTurn.g:275:101: ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ )
            	    // InternalTurn.g:276:5: ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6);
            	    				
            	    // InternalTurn.g:279:8: ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==58) ) {
            	            int LA6_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt6=1;
            	            }


            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalTurn.g:279:9: {...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:279:18: ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) )
            	    	    // InternalTurn.g:279:19: (lv_contribContextGroups_9_0= ruleContributionContextGroup )
            	    	    {
            	    	    // InternalTurn.g:279:19: (lv_contribContextGroups_9_0= ruleContributionContextGroup )
            	    	    // InternalTurn.g:280:9: lv_contribContextGroups_9_0= ruleContributionContextGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getContribContextGroupsContributionContextGroupParserRuleCall_6_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_contribContextGroups_9_0=ruleContributionContextGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"contribContextGroups",
            	    	    										lv_contribContextGroups_9_0,
            	    	    										"org.jucmnav.turn.Turn.ContributionContextGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalTurn.g:302:3: ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) )
            	    {
            	    // InternalTurn.g:302:3: ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) )
            	    // InternalTurn.g:303:4: {...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7)");
            	    }
            	    // InternalTurn.g:303:101: ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ )
            	    // InternalTurn.g:304:5: ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7);
            	    				
            	    // InternalTurn.g:307:8: ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==59) ) {
            	            int LA7_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt7=1;
            	            }


            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalTurn.g:307:9: {...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:307:18: ( (lv_contribContexts_10_0= ruleContributionContext ) )
            	    	    // InternalTurn.g:307:19: (lv_contribContexts_10_0= ruleContributionContext )
            	    	    {
            	    	    // InternalTurn.g:307:19: (lv_contribContexts_10_0= ruleContributionContext )
            	    	    // InternalTurn.g:308:9: lv_contribContexts_10_0= ruleContributionContext
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getContribContextsContributionContextParserRuleCall_7_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_contribContexts_10_0=ruleContributionContext();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"contribContexts",
            	    	    										lv_contribContexts_10_0,
            	    	    										"org.jucmnav.turn.Turn.ContributionContext");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalTurn.g:330:3: ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) )
            	    {
            	    // InternalTurn.g:330:3: ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) )
            	    // InternalTurn.g:331:4: {...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8)");
            	    }
            	    // InternalTurn.g:331:101: ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ )
            	    // InternalTurn.g:332:5: ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8);
            	    				
            	    // InternalTurn.g:335:8: ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==62) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }
            	        else if ( (LA8_0==63) ) {
            	            int LA8_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalTurn.g:335:9: {...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:335:18: ( (lv_ucmMaps_11_0= ruleUCMmap ) )
            	    	    // InternalTurn.g:335:19: (lv_ucmMaps_11_0= ruleUCMmap )
            	    	    {
            	    	    // InternalTurn.g:335:19: (lv_ucmMaps_11_0= ruleUCMmap )
            	    	    // InternalTurn.g:336:9: lv_ucmMaps_11_0= ruleUCMmap
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getUcmMapsUCMmapParserRuleCall_8_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_ucmMaps_11_0=ruleUCMmap();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"ucmMaps",
            	    	    										lv_ucmMaps_11_0,
            	    	    										"org.jucmnav.turn.Turn.UCMmap");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalTurn.g:358:3: ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) )
            	    {
            	    // InternalTurn.g:358:3: ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) )
            	    // InternalTurn.g:359:4: {...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9)");
            	    }
            	    // InternalTurn.g:359:101: ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ )
            	    // InternalTurn.g:360:5: ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9);
            	    				
            	    // InternalTurn.g:363:8: ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==92) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalTurn.g:363:9: {...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:363:18: ( (lv_scenGroups_12_0= ruleScenarioGroup ) )
            	    	    // InternalTurn.g:363:19: (lv_scenGroups_12_0= ruleScenarioGroup )
            	    	    {
            	    	    // InternalTurn.g:363:19: (lv_scenGroups_12_0= ruleScenarioGroup )
            	    	    // InternalTurn.g:364:9: lv_scenGroups_12_0= ruleScenarioGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getScenGroupsScenarioGroupParserRuleCall_9_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_scenGroups_12_0=ruleScenarioGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"scenGroups",
            	    	    										lv_scenGroups_12_0,
            	    	    										"org.jucmnav.turn.Turn.ScenarioGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalTurn.g:386:3: ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) )
            	    {
            	    // InternalTurn.g:386:3: ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) )
            	    // InternalTurn.g:387:4: {...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10)");
            	    }
            	    // InternalTurn.g:387:102: ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ )
            	    // InternalTurn.g:388:5: ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10);
            	    				
            	    // InternalTurn.g:391:8: ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==93) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalTurn.g:391:9: {...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:391:18: ( (lv_scenDefs_13_0= ruleScenarioDef ) )
            	    	    // InternalTurn.g:391:19: (lv_scenDefs_13_0= ruleScenarioDef )
            	    	    {
            	    	    // InternalTurn.g:391:19: (lv_scenDefs_13_0= ruleScenarioDef )
            	    	    // InternalTurn.g:392:9: lv_scenDefs_13_0= ruleScenarioDef
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getScenDefsScenarioDefParserRuleCall_10_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_scenDefs_13_0=ruleScenarioDef();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"scenDefs",
            	    	    										lv_scenDefs_13_0,
            	    	    										"org.jucmnav.turn.Turn.ScenarioDef");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // InternalTurn.g:414:3: ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) )
            	    {
            	    // InternalTurn.g:414:3: ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) )
            	    // InternalTurn.g:415:4: {...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11)");
            	    }
            	    // InternalTurn.g:415:102: ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ )
            	    // InternalTurn.g:416:5: ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11);
            	    				
            	    // InternalTurn.g:419:8: ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        switch ( input.LA(1) ) {
            	        case 132:
            	            {
            	            int LA11_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	            }
            	            break;
            	        case 133:
            	            {
            	            int LA11_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA11_4 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalTurn.g:419:9: {...}? => ( (lv_variables_14_0= ruleVariable ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:419:18: ( (lv_variables_14_0= ruleVariable ) )
            	    	    // InternalTurn.g:419:19: (lv_variables_14_0= ruleVariable )
            	    	    {
            	    	    // InternalTurn.g:419:19: (lv_variables_14_0= ruleVariable )
            	    	    // InternalTurn.g:420:9: lv_variables_14_0= ruleVariable
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getVariablesVariableParserRuleCall_11_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_variables_14_0=ruleVariable();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"variables",
            	    	    										lv_variables_14_0,
            	    	    										"org.jucmnav.turn.Turn.Variable");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // InternalTurn.g:442:3: ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) )
            	    {
            	    // InternalTurn.g:442:3: ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) )
            	    // InternalTurn.g:443:4: {...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12)");
            	    }
            	    // InternalTurn.g:443:102: ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ )
            	    // InternalTurn.g:444:5: ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12);
            	    				
            	    // InternalTurn.g:447:8: ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==97) ) {
            	            int LA12_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt12=1;
            	            }


            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalTurn.g:447:9: {...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:447:18: ( (lv_enumTypes_15_0= ruleEnumerationType ) )
            	    	    // InternalTurn.g:447:19: (lv_enumTypes_15_0= ruleEnumerationType )
            	    	    {
            	    	    // InternalTurn.g:447:19: (lv_enumTypes_15_0= ruleEnumerationType )
            	    	    // InternalTurn.g:448:9: lv_enumTypes_15_0= ruleEnumerationType
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getEnumTypesEnumerationTypeParserRuleCall_12_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_enumTypes_15_0=ruleEnumerationType();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"enumTypes",
            	    	    										lv_enumTypes_15_0,
            	    	    										"org.jucmnav.turn.Turn.EnumerationType");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // InternalTurn.g:470:3: ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) )
            	    {
            	    // InternalTurn.g:470:3: ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) )
            	    // InternalTurn.g:471:4: {...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13)");
            	    }
            	    // InternalTurn.g:471:102: ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ )
            	    // InternalTurn.g:472:5: ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13);
            	    				
            	    // InternalTurn.g:475:8: ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+
            	    int cnt13=0;
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( (LA13_0==21) ) {
            	            int LA13_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt13=1;
            	            }


            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // InternalTurn.g:475:9: {...}? => ( (lv_concerns_16_0= ruleConcern ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:475:18: ( (lv_concerns_16_0= ruleConcern ) )
            	    	    // InternalTurn.g:475:19: (lv_concerns_16_0= ruleConcern )
            	    	    {
            	    	    // InternalTurn.g:475:19: (lv_concerns_16_0= ruleConcern )
            	    	    // InternalTurn.g:476:9: lv_concerns_16_0= ruleConcern
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getConcernsConcernParserRuleCall_13_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_concerns_16_0=ruleConcern();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"concerns",
            	    	    										lv_concerns_16_0,
            	    	    										"org.jucmnav.turn.Turn.Concern");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt13 >= 1 ) break loop13;
            	                EarlyExitException eee =
            	                    new EarlyExitException(13, input);
            	                throw eee;
            	        }
            	        cnt13++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // InternalTurn.g:498:3: ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) )
            	    {
            	    // InternalTurn.g:498:3: ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) )
            	    // InternalTurn.g:499:4: {...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14)");
            	    }
            	    // InternalTurn.g:499:102: ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ )
            	    // InternalTurn.g:500:5: ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14);
            	    				
            	    // InternalTurn.g:503:8: ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+
            	    int cnt14=0;
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==26) ) {
            	            int LA14_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt14=1;
            	            }


            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // InternalTurn.g:503:9: {...}? => ( (lv_urnlinks_17_0= ruleURNlink ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:503:18: ( (lv_urnlinks_17_0= ruleURNlink ) )
            	    	    // InternalTurn.g:503:19: (lv_urnlinks_17_0= ruleURNlink )
            	    	    {
            	    	    // InternalTurn.g:503:19: (lv_urnlinks_17_0= ruleURNlink )
            	    	    // InternalTurn.g:504:9: lv_urnlinks_17_0= ruleURNlink
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getUrnlinksURNlinkParserRuleCall_14_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_urnlinks_17_0=ruleURNlink();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"urnlinks",
            	    	    										lv_urnlinks_17_0,
            	    	    										"org.jucmnav.turn.Turn.URNlink");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt14 >= 1 ) break loop14;
            	                EarlyExitException eee =
            	                    new EarlyExitException(14, input);
            	                throw eee;
            	        }
            	        cnt14++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // InternalTurn.g:526:3: ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) )
            	    {
            	    // InternalTurn.g:526:3: ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) )
            	    // InternalTurn.g:527:4: {...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15)");
            	    }
            	    // InternalTurn.g:527:102: ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ )
            	    // InternalTurn.g:528:5: ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15);
            	    				
            	    // InternalTurn.g:531:8: ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+
            	    int cnt15=0;
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==29) ) {
            	            int LA15_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt15=1;
            	            }


            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // InternalTurn.g:531:9: {...}? => ( (lv_metadata_18_0= ruleMetadata ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:531:18: ( (lv_metadata_18_0= ruleMetadata ) )
            	    	    // InternalTurn.g:531:19: (lv_metadata_18_0= ruleMetadata )
            	    	    {
            	    	    // InternalTurn.g:531:19: (lv_metadata_18_0= ruleMetadata )
            	    	    // InternalTurn.g:532:9: lv_metadata_18_0= ruleMetadata
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getMetadataMetadataParserRuleCall_15_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_metadata_18_0=ruleMetadata();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"metadata",
            	    	    										lv_metadata_18_0,
            	    	    										"org.jucmnav.turn.Turn.Metadata");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt15 >= 1 ) break loop15;
            	                EarlyExitException eee =
            	                    new EarlyExitException(15, input);
            	                throw eee;
            	        }
            	        cnt15++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getURNspecAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canLeave(grammarAccess.getURNspecAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getURNspecAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURNspec"


    // $ANTLR start "entryRuleConcreteURNspec"
    // InternalTurn.g:565:1: entryRuleConcreteURNspec returns [EObject current=null] : iv_ruleConcreteURNspec= ruleConcreteURNspec EOF ;
    public final EObject entryRuleConcreteURNspec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteURNspec = null;


        try {
            // InternalTurn.g:565:56: (iv_ruleConcreteURNspec= ruleConcreteURNspec EOF )
            // InternalTurn.g:566:2: iv_ruleConcreteURNspec= ruleConcreteURNspec EOF
            {
             newCompositeNode(grammarAccess.getConcreteURNspecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteURNspec=ruleConcreteURNspec();

            state._fsp--;

             current =iv_ruleConcreteURNspec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteURNspec"


    // $ANTLR start "ruleConcreteURNspec"
    // InternalTurn.g:572:1: ruleConcreteURNspec returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) ;
    public final EObject ruleConcreteURNspec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_description_2_0=null;
        Token otherlv_3=null;
        Token lv_author_4_0=null;
        Token otherlv_5=null;
        Token lv_created_6_0=null;
        Token otherlv_7=null;
        Token lv_modified_8_0=null;
        Token otherlv_9=null;
        Token lv_specVersion_10_0=null;
        Token otherlv_11=null;
        Token lv_urnVersion_12_0=null;
        Token otherlv_13=null;


        	enterRule();

        try {
            // InternalTurn.g:578:2: ( (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) )
            // InternalTurn.g:579:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            {
            // InternalTurn.g:579:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            // InternalTurn.g:580:3: otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteURNspecAccess().getLeftCurlyBracketKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getConcreteURNspecAccess().getDescriptionKeyword_1());
            		
            // InternalTurn.g:588:3: ( (lv_description_2_0= RULE_STRING ) )
            // InternalTurn.g:589:4: (lv_description_2_0= RULE_STRING )
            {
            // InternalTurn.g:589:4: (lv_description_2_0= RULE_STRING )
            // InternalTurn.g:590:5: lv_description_2_0= RULE_STRING
            {
            lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_description_2_0, grammarAccess.getConcreteURNspecAccess().getDescriptionSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getConcreteURNspecAccess().getAuthorKeyword_3());
            		
            // InternalTurn.g:610:3: ( (lv_author_4_0= RULE_STRING ) )
            // InternalTurn.g:611:4: (lv_author_4_0= RULE_STRING )
            {
            // InternalTurn.g:611:4: (lv_author_4_0= RULE_STRING )
            // InternalTurn.g:612:5: lv_author_4_0= RULE_STRING
            {
            lv_author_4_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_author_4_0, grammarAccess.getConcreteURNspecAccess().getAuthorSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"author",
            						lv_author_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getConcreteURNspecAccess().getCreatedKeyword_5());
            		
            // InternalTurn.g:632:3: ( (lv_created_6_0= RULE_STRING ) )
            // InternalTurn.g:633:4: (lv_created_6_0= RULE_STRING )
            {
            // InternalTurn.g:633:4: (lv_created_6_0= RULE_STRING )
            // InternalTurn.g:634:5: lv_created_6_0= RULE_STRING
            {
            lv_created_6_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_created_6_0, grammarAccess.getConcreteURNspecAccess().getCreatedSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"created",
            						lv_created_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getConcreteURNspecAccess().getModifiedKeyword_7());
            		
            // InternalTurn.g:654:3: ( (lv_modified_8_0= RULE_STRING ) )
            // InternalTurn.g:655:4: (lv_modified_8_0= RULE_STRING )
            {
            // InternalTurn.g:655:4: (lv_modified_8_0= RULE_STRING )
            // InternalTurn.g:656:5: lv_modified_8_0= RULE_STRING
            {
            lv_modified_8_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_modified_8_0, grammarAccess.getConcreteURNspecAccess().getModifiedSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"modified",
            						lv_modified_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getConcreteURNspecAccess().getVersionKeyword_9());
            		
            // InternalTurn.g:676:3: ( (lv_specVersion_10_0= RULE_STRING ) )
            // InternalTurn.g:677:4: (lv_specVersion_10_0= RULE_STRING )
            {
            // InternalTurn.g:677:4: (lv_specVersion_10_0= RULE_STRING )
            // InternalTurn.g:678:5: lv_specVersion_10_0= RULE_STRING
            {
            lv_specVersion_10_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_specVersion_10_0, grammarAccess.getConcreteURNspecAccess().getSpecVersionSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"specVersion",
            						lv_specVersion_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_11, grammarAccess.getConcreteURNspecAccess().getUrnVersionKeyword_11());
            		
            // InternalTurn.g:698:3: ( (lv_urnVersion_12_0= RULE_STRING ) )
            // InternalTurn.g:699:4: (lv_urnVersion_12_0= RULE_STRING )
            {
            // InternalTurn.g:699:4: (lv_urnVersion_12_0= RULE_STRING )
            // InternalTurn.g:700:5: lv_urnVersion_12_0= RULE_STRING
            {
            lv_urnVersion_12_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_urnVersion_12_0, grammarAccess.getConcreteURNspecAccess().getUrnVersionSTRINGTerminalRuleCall_12_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"urnVersion",
            						lv_urnVersion_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getConcreteURNspecAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteURNspec"


    // $ANTLR start "entryRuleConcern"
    // InternalTurn.g:724:1: entryRuleConcern returns [EObject current=null] : iv_ruleConcern= ruleConcern EOF ;
    public final EObject entryRuleConcern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcern = null;


        try {
            // InternalTurn.g:724:48: (iv_ruleConcern= ruleConcern EOF )
            // InternalTurn.g:725:2: iv_ruleConcern= ruleConcern EOF
            {
             newCompositeNode(grammarAccess.getConcernRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcern=ruleConcern();

            state._fsp--;

             current =iv_ruleConcern; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcern"


    // $ANTLR start "ruleConcern"
    // InternalTurn.g:731:1: ruleConcern returns [EObject current=null] : (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleConcern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:737:2: ( (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* ) )
            // InternalTurn.g:738:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // InternalTurn.g:738:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )
            // InternalTurn.g:739:3: otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConcernAccess().getConcernKeyword_0());
            		
            // InternalTurn.g:743:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:744:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:744:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:745:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getConcernAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcernRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:762:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:763:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:763:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:764:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getConcernAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcernRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getConcernAccess().getColonKeyword_3());
            		
            // InternalTurn.g:785:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTurn.g:786:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTurn.g:786:4: (lv_condition_4_0= ruleCondition )
                    // InternalTurn.g:787:5: lv_condition_4_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getConcernAccess().getConditionConditionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_condition_4_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConcernRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_4_0,
                    						"org.jucmnav.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:804:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:805:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:805:4: ( ruleQualifiedName )
            // InternalTurn.g:806:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcernRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcernAccess().getElementURNmodelElementCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:820:3: (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTurn.g:821:4: otherlv_6= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_6, grammarAccess.getConcernAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTurn.g:825:4: ( ( ruleQualifiedName ) )
            	    // InternalTurn.g:826:5: ( ruleQualifiedName )
            	    {
            	    // InternalTurn.g:826:5: ( ruleQualifiedName )
            	    // InternalTurn.g:827:6: ruleQualifiedName
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getConcernRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getConcernAccess().getElementsURNmodelElementCrossReference_6_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcern"


    // $ANTLR start "entryRuleCondition"
    // InternalTurn.g:846:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalTurn.g:846:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalTurn.g:847:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalTurn.g:853:1: ruleCondition returns [EObject current=null] : (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_1_0 = null;

        EObject lv_info_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:859:2: ( (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) )
            // InternalTurn.g:860:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            {
            // InternalTurn.g:860:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            // InternalTurn.g:861:3: otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalTurn.g:865:3: ( (lv_expression_1_0= ruleText ) )
            // InternalTurn.g:866:4: (lv_expression_1_0= ruleText )
            {
            // InternalTurn.g:866:4: (lv_expression_1_0= ruleText )
            // InternalTurn.g:867:5: lv_expression_1_0= ruleText
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getExpressionTextParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_expression_1_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_1_0,
            						"org.jucmnav.turn.Turn.Text");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getRightSquareBracketKeyword_2());
            		
            // InternalTurn.g:888:3: (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==13) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTurn.g:889:4: otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_20); 

                    				newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalTurn.g:893:4: ( (lv_info_4_0= ruleConcreteCondition ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_STRING) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalTurn.g:894:5: (lv_info_4_0= ruleConcreteCondition )
                            {
                            // InternalTurn.g:894:5: (lv_info_4_0= ruleConcreteCondition )
                            // InternalTurn.g:895:6: lv_info_4_0= ruleConcreteCondition
                            {

                            						newCompositeNode(grammarAccess.getConditionAccess().getInfoConcreteConditionParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_12);
                            lv_info_4_0=ruleConcreteCondition();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getConditionRule());
                            						}
                            						set(
                            							current,
                            							"info",
                            							lv_info_4_0,
                            							"org.jucmnav.turn.Turn.ConcreteCondition");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_3_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleConcreteCondition"
    // InternalTurn.g:921:1: entryRuleConcreteCondition returns [EObject current=null] : iv_ruleConcreteCondition= ruleConcreteCondition EOF ;
    public final EObject entryRuleConcreteCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteCondition = null;


        try {
            // InternalTurn.g:921:58: (iv_ruleConcreteCondition= ruleConcreteCondition EOF )
            // InternalTurn.g:922:2: iv_ruleConcreteCondition= ruleConcreteCondition EOF
            {
             newCompositeNode(grammarAccess.getConcreteConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteCondition=ruleConcreteCondition();

            state._fsp--;

             current =iv_ruleConcreteCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteCondition"


    // $ANTLR start "ruleConcreteCondition"
    // InternalTurn.g:928:1: ruleConcreteCondition returns [EObject current=null] : ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteCondition() throws RecognitionException {
        EObject current = null;

        Token lv_label_0_0=null;
        Token lv_description_1_0=null;


        	enterRule();

        try {
            // InternalTurn.g:934:2: ( ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) )
            // InternalTurn.g:935:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // InternalTurn.g:935:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            // InternalTurn.g:936:3: ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) )
            {
            // InternalTurn.g:936:3: ( (lv_label_0_0= RULE_STRING ) )
            // InternalTurn.g:937:4: (lv_label_0_0= RULE_STRING )
            {
            // InternalTurn.g:937:4: (lv_label_0_0= RULE_STRING )
            // InternalTurn.g:938:5: lv_label_0_0= RULE_STRING
            {
            lv_label_0_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

            					newLeafNode(lv_label_0_0, grammarAccess.getConcreteConditionAccess().getLabelSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"label",
            						lv_label_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTurn.g:954:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalTurn.g:955:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalTurn.g:955:4: (lv_description_1_0= RULE_STRING )
            // InternalTurn.g:956:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_description_1_0, grammarAccess.getConcreteConditionAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteCondition"


    // $ANTLR start "entryRuleURNlink"
    // InternalTurn.g:976:1: entryRuleURNlink returns [EObject current=null] : iv_ruleURNlink= ruleURNlink EOF ;
    public final EObject entryRuleURNlink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURNlink = null;


        try {
            // InternalTurn.g:976:48: (iv_ruleURNlink= ruleURNlink EOF )
            // InternalTurn.g:977:2: iv_ruleURNlink= ruleURNlink EOF
            {
             newCompositeNode(grammarAccess.getURNlinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURNlink=ruleURNlink();

            state._fsp--;

             current =iv_ruleURNlink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURNlink"


    // $ANTLR start "ruleURNlink"
    // InternalTurn.g:983:1: ruleURNlink returns [EObject current=null] : (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleURNlink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:989:2: ( (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:990:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:990:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:991:3: otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getURNlinkAccess().getLinkKeyword_0());
            		
            // InternalTurn.g:995:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalTurn.g:996:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':'
                    {
                    // InternalTurn.g:996:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:997:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:997:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:998:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:1015:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:1016:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:1016:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:1017:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getURNlinkAccess().getColonKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:1039:3: (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTurn.g:1040:4: otherlv_4= 'type' ( (lv_type_5_0= ruleText ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_17); 

                    				newLeafNode(otherlv_4, grammarAccess.getURNlinkAccess().getTypeKeyword_2_0());
                    			
                    // InternalTurn.g:1044:4: ( (lv_type_5_0= ruleText ) )
                    // InternalTurn.g:1045:5: (lv_type_5_0= ruleText )
                    {
                    // InternalTurn.g:1045:5: (lv_type_5_0= ruleText )
                    // InternalTurn.g:1046:6: lv_type_5_0= ruleText
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getTypeTextParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_type_5_0=ruleText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_5_0,
                    							"org.jucmnav.turn.Turn.Text");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:1064:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1065:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1065:4: ( ruleQualifiedName )
            // InternalTurn.g:1066:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURNlinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getURNlinkAccess().getFromElemURNmodelElementCrossReference_3_0());
            				
            pushFollow(FOLLOW_22);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getURNlinkAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalTurn.g:1084:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1085:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1085:4: ( ruleQualifiedName )
            // InternalTurn.g:1086:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURNlinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getURNlinkAccess().getToElemURNmodelElementCrossReference_5_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURNlink"


    // $ANTLR start "entryRuleMetadata"
    // InternalTurn.g:1104:1: entryRuleMetadata returns [EObject current=null] : iv_ruleMetadata= ruleMetadata EOF ;
    public final EObject entryRuleMetadata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadata = null;


        try {
            // InternalTurn.g:1104:49: (iv_ruleMetadata= ruleMetadata EOF )
            // InternalTurn.g:1105:2: iv_ruleMetadata= ruleMetadata EOF
            {
             newCompositeNode(grammarAccess.getMetadataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetadata=ruleMetadata();

            state._fsp--;

             current =iv_ruleMetadata; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetadata"


    // $ANTLR start "ruleMetadata"
    // InternalTurn.g:1111:1: ruleMetadata returns [EObject current=null] : (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) ) ;
    public final EObject ruleMetadata() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1117:2: ( (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) ) )
            // InternalTurn.g:1118:2: (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) )
            {
            // InternalTurn.g:1118:2: (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) )
            // InternalTurn.g:1119:3: otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMetadataAccess().getMetadataKeyword_0());
            		
            // InternalTurn.g:1123:3: ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==22||LA23_1==37) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // InternalTurn.g:1124:4: ( ( ruleQualifiedName ) ) otherlv_2= ':'
                    {
                    // InternalTurn.g:1124:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:1125:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:1125:5: ( ruleQualifiedName )
                    // InternalTurn.g:1126:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMetadataRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getMetadataAccess().getElemURNmodelElementCrossReference_1_0_0());
                    					
                    pushFollow(FOLLOW_14);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getMetadataAccess().getColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalTurn.g:1145:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTurn.g:1146:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTurn.g:1146:4: (lv_name_3_0= RULE_ID )
            // InternalTurn.g:1147:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_name_3_0, grammarAccess.getMetadataAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetadataRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getMetadataAccess().getEqualsSignKeyword_3());
            		
            // InternalTurn.g:1167:3: ( (lv_value_5_0= ruleText ) )
            // InternalTurn.g:1168:4: (lv_value_5_0= ruleText )
            {
            // InternalTurn.g:1168:4: (lv_value_5_0= ruleText )
            // InternalTurn.g:1169:5: lv_value_5_0= ruleText
            {

            					newCompositeNode(grammarAccess.getMetadataAccess().getValueTextParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_5_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetadataRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"org.jucmnav.turn.Turn.Text");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadata"


    // $ANTLR start "entryRuleArtificialRule"
    // InternalTurn.g:1190:1: entryRuleArtificialRule returns [EObject current=null] : iv_ruleArtificialRule= ruleArtificialRule EOF ;
    public final EObject entryRuleArtificialRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtificialRule = null;


        try {
            // InternalTurn.g:1190:55: (iv_ruleArtificialRule= ruleArtificialRule EOF )
            // InternalTurn.g:1191:2: iv_ruleArtificialRule= ruleArtificialRule EOF
            {
             newCompositeNode(grammarAccess.getArtificialRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArtificialRule=ruleArtificialRule();

            state._fsp--;

             current =iv_ruleArtificialRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArtificialRule"


    // $ANTLR start "ruleArtificialRule"
    // InternalTurn.g:1197:1: ruleArtificialRule returns [EObject current=null] : ( (lv_longName_0_0= RULE_STRING ) )? ;
    public final EObject ruleArtificialRule() throws RecognitionException {
        EObject current = null;

        Token lv_longName_0_0=null;


        	enterRule();

        try {
            // InternalTurn.g:1203:2: ( ( (lv_longName_0_0= RULE_STRING ) )? )
            // InternalTurn.g:1204:2: ( (lv_longName_0_0= RULE_STRING ) )?
            {
            // InternalTurn.g:1204:2: ( (lv_longName_0_0= RULE_STRING ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_STRING) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTurn.g:1205:3: (lv_longName_0_0= RULE_STRING )
                    {
                    // InternalTurn.g:1205:3: (lv_longName_0_0= RULE_STRING )
                    // InternalTurn.g:1206:4: lv_longName_0_0= RULE_STRING
                    {
                    lv_longName_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    				newLeafNode(lv_longName_0_0, grammarAccess.getArtificialRuleAccess().getLongNameSTRINGTerminalRuleCall_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getArtificialRuleRule());
                    				}
                    				setWithLastConsumed(
                    					current,
                    					"longName",
                    					lv_longName_0_0,
                    					"org.eclipse.xtext.common.Terminals.STRING");
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArtificialRule"


    // $ANTLR start "entryRuleText"
    // InternalTurn.g:1225:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalTurn.g:1225:45: (iv_ruleText= ruleText EOF )
            // InternalTurn.g:1226:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalTurn.g:1232:1: ruleText returns [EObject current=null] : ( (lv_content_0_0= ruleTextContent ) )+ ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_content_0_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1238:2: ( ( (lv_content_0_0= ruleTextContent ) )+ )
            // InternalTurn.g:1239:2: ( (lv_content_0_0= ruleTextContent ) )+
            {
            // InternalTurn.g:1239:2: ( (lv_content_0_0= ruleTextContent ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    int LA25_2 = input.LA(2);

                    if ( (LA25_2==EOF||(LA25_2>=RULE_ID && LA25_2<=RULE_INT)||(LA25_2>=11 && LA25_2<=12)||LA25_2==21||(LA25_2>=25 && LA25_2<=26)||LA25_2==29||LA25_2==31||(LA25_2>=33 && LA25_2<=36)||LA25_2==38||(LA25_2>=46 && LA25_2<=47)||LA25_2==53||(LA25_2>=57 && LA25_2<=59)||(LA25_2>=62 && LA25_2<=63)||(LA25_2>=92 && LA25_2<=93)||LA25_2==97||(LA25_2>=132 && LA25_2<=133)) ) {
                        alt25=1;
                    }
                    else if ( (LA25_2==32) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==RULE_INT||(LA25_0>=31 && LA25_0<=36)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalTurn.g:1240:3: (lv_content_0_0= ruleTextContent )
            	    {
            	    // InternalTurn.g:1240:3: (lv_content_0_0= ruleTextContent )
            	    // InternalTurn.g:1241:4: lv_content_0_0= ruleTextContent
            	    {

            	    				newCompositeNode(grammarAccess.getTextAccess().getContentTextContentParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_24);
            	    lv_content_0_0=ruleTextContent();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getTextRule());
            	    				}
            	    				add(
            	    					current,
            	    					"content",
            	    					lv_content_0_0,
            	    					"org.jucmnav.turn.Turn.TextContent");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleLongName"
    // InternalTurn.g:1261:1: entryRuleLongName returns [EObject current=null] : iv_ruleLongName= ruleLongName EOF ;
    public final EObject entryRuleLongName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongName = null;


        try {
            // InternalTurn.g:1261:49: (iv_ruleLongName= ruleLongName EOF )
            // InternalTurn.g:1262:2: iv_ruleLongName= ruleLongName EOF
            {
             newCompositeNode(grammarAccess.getLongNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongName=ruleLongName();

            state._fsp--;

             current =iv_ruleLongName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongName"


    // $ANTLR start "ruleLongName"
    // InternalTurn.g:1268:1: ruleLongName returns [EObject current=null] : ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) ;
    public final EObject ruleLongName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_longname_2_1=null;
        Token lv_longname_2_2=null;


        	enterRule();

        try {
            // InternalTurn.g:1274:2: ( ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) )
            // InternalTurn.g:1275:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            {
            // InternalTurn.g:1275:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            // InternalTurn.g:1276:3: () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            {
            // InternalTurn.g:1276:3: ()
            // InternalTurn.g:1277:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLongNameAccess().getLongNameAction_0(),
            					current);
            			

            }

            // InternalTurn.g:1283:3: (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==31) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTurn.g:1284:4: otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_25); 

                    				newLeafNode(otherlv_1, grammarAccess.getLongNameAccess().getNumberSignKeyword_1_0());
                    			
                    // InternalTurn.g:1288:4: ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    // InternalTurn.g:1289:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    {
                    // InternalTurn.g:1289:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    // InternalTurn.g:1290:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    {
                    // InternalTurn.g:1290:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_ID) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_STRING) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalTurn.g:1291:7: lv_longname_2_1= RULE_ID
                            {
                            lv_longname_2_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                            							newLeafNode(lv_longname_2_1, grammarAccess.getLongNameAccess().getLongnameIDTerminalRuleCall_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getLongNameRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"longname",
                            								lv_longname_2_1,
                            								"org.eclipse.xtext.common.Terminals.ID");
                            						

                            }
                            break;
                        case 2 :
                            // InternalTurn.g:1306:7: lv_longname_2_2= RULE_STRING
                            {
                            lv_longname_2_2=(Token)match(input,RULE_STRING,FOLLOW_2); 

                            							newLeafNode(lv_longname_2_2, grammarAccess.getLongNameAccess().getLongnameSTRINGTerminalRuleCall_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getLongNameRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"longname",
                            								lv_longname_2_2,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongName"


    // $ANTLR start "entryRuleTextContent"
    // InternalTurn.g:1328:1: entryRuleTextContent returns [String current=null] : iv_ruleTextContent= ruleTextContent EOF ;
    public final String entryRuleTextContent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTextContent = null;


        try {
            // InternalTurn.g:1328:51: (iv_ruleTextContent= ruleTextContent EOF )
            // InternalTurn.g:1329:2: iv_ruleTextContent= ruleTextContent EOF
            {
             newCompositeNode(grammarAccess.getTextContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextContent=ruleTextContent();

            state._fsp--;

             current =iv_ruleTextContent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextContent"


    // $ANTLR start "ruleTextContent"
    // InternalTurn.g:1335:1: ruleTextContent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleTextContent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalTurn.g:1341:2: ( (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) )
            // InternalTurn.g:1342:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            {
            // InternalTurn.g:1342:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            int alt28=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt28=1;
                }
                break;
            case 32:
                {
                alt28=2;
                }
                break;
            case 31:
                {
                alt28=3;
                }
                break;
            case 33:
                {
                alt28=4;
                }
                break;
            case 34:
                {
                alt28=5;
                }
                break;
            case 35:
                {
                alt28=6;
                }
                break;
            case 36:
                {
                alt28=7;
                }
                break;
            case RULE_INT:
                {
                alt28=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalTurn.g:1343:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getTextContentAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:1351:3: kw= '@'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getCommercialAtKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:1357:3: kw= '#'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getNumberSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalTurn.g:1363:3: kw= '!'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getExclamationMarkKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalTurn.g:1369:3: kw= '%'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getPercentSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalTurn.g:1375:3: kw= '&'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalTurn.g:1381:3: kw= '*'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAsteriskKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalTurn.g:1387:3: this_INT_7= RULE_INT
                    {
                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_7);
                    		

                    			newLeafNode(this_INT_7, grammarAccess.getTextContentAccess().getINTTerminalRuleCall_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextContent"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTurn.g:1398:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTurn.g:1398:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTurn.g:1399:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTurn.g:1405:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTurn.g:1411:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTurn.g:1412:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTurn.g:1412:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTurn.g:1413:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalTurn.g:1420:3: (kw= '.' this_ID_2= RULE_ID )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==37) ) {
                    int LA29_2 = input.LA(2);

                    if ( (LA29_2==RULE_ID) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // InternalTurn.g:1421:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,37,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_26); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleActor"
    // InternalTurn.g:1438:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalTurn.g:1438:46: (iv_ruleActor= ruleActor EOF )
            // InternalTurn.g:1439:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalTurn.g:1445:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        Enumerator lv_importance_5_0 = null;

        AntlrDatatypeRuleToken lv_importanceQuantitative_6_0 = null;

        EObject lv_elems_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1451:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) )
            // InternalTurn.g:1452:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            {
            // InternalTurn.g:1452:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            // InternalTurn.g:1453:3: otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalTurn.g:1457:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1458:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1458:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1459:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getActorAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1476:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1477:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1477:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1478:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getActorAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_29); 

            			newLeafNode(otherlv_3, grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:1499:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTurn.g:1500:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,39,FOLLOW_30); 

                    				newLeafNode(otherlv_4, grammarAccess.getActorAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTurn.g:1504:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==104||(LA30_0>=117 && LA30_0<=119)) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==RULE_INT||(LA30_0>=60 && LA30_0<=61)) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalTurn.g:1505:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTurn.g:1505:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTurn.g:1506:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTurn.g:1506:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTurn.g:1507:7: lv_importance_5_0= ruleImportanceType
                            {

                            							newCompositeNode(grammarAccess.getActorAccess().getImportanceImportanceTypeEnumRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_31);
                            lv_importance_5_0=ruleImportanceType();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getActorRule());
                            							}
                            							set(
                            								current,
                            								"importance",
                            								lv_importance_5_0,
                            								"org.jucmnav.turn.Turn.ImportanceType");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTurn.g:1525:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:1525:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:1526:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:1526:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTurn.g:1527:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
                            {

                            							newCompositeNode(grammarAccess.getActorAccess().getImportanceQuantitativeQuantitativeValueParserRuleCall_4_1_1_0());
                            						
                            pushFollow(FOLLOW_31);
                            lv_importanceQuantitative_6_0=ruleQuantitativeValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getActorRule());
                            							}
                            							set(
                            								current,
                            								"importanceQuantitative",
                            								lv_importanceQuantitative_6_0,
                            								"org.jucmnav.turn.Turn.QuantitativeValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalTurn.g:1546:3: ( (lv_elems_7_0= ruleIntentionalElement ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=105 && LA32_0<=110)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalTurn.g:1547:4: (lv_elems_7_0= ruleIntentionalElement )
            	    {
            	    // InternalTurn.g:1547:4: (lv_elems_7_0= ruleIntentionalElement )
            	    // InternalTurn.g:1548:5: lv_elems_7_0= ruleIntentionalElement
            	    {

            	    					newCompositeNode(grammarAccess.getActorAccess().getElemsIntentionalElementParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_elems_7_0=ruleIntentionalElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elems",
            	    						lv_elems_7_0,
            	    						"org.jucmnav.turn.Turn.IntentionalElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getActorAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleIntentionalElement"
    // InternalTurn.g:1573:1: entryRuleIntentionalElement returns [EObject current=null] : iv_ruleIntentionalElement= ruleIntentionalElement EOF ;
    public final EObject entryRuleIntentionalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentionalElement = null;


        try {
            // InternalTurn.g:1573:59: (iv_ruleIntentionalElement= ruleIntentionalElement EOF )
            // InternalTurn.g:1574:2: iv_ruleIntentionalElement= ruleIntentionalElement EOF
            {
             newCompositeNode(grammarAccess.getIntentionalElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntentionalElement=ruleIntentionalElement();

            state._fsp--;

             current =iv_ruleIntentionalElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntentionalElement"


    // $ANTLR start "ruleIntentionalElement"
    // InternalTurn.g:1580:1: ruleIntentionalElement returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) ;
    public final EObject ruleIntentionalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token lv_unit_8_0=null;
        Token otherlv_10=null;
        Enumerator lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        Enumerator lv_importance_5_0 = null;

        AntlrDatatypeRuleToken lv_importanceQuantitative_6_0 = null;

        EObject lv_linksSrc_9_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1586:2: ( ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) )
            // InternalTurn.g:1587:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            {
            // InternalTurn.g:1587:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            // InternalTurn.g:1588:3: ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}'
            {
            // InternalTurn.g:1588:3: ( (lv_type_0_0= ruleIntentionalElementType ) )
            // InternalTurn.g:1589:4: (lv_type_0_0= ruleIntentionalElementType )
            {
            // InternalTurn.g:1589:4: (lv_type_0_0= ruleIntentionalElementType )
            // InternalTurn.g:1590:5: lv_type_0_0= ruleIntentionalElementType
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getTypeIntentionalElementTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleIntentionalElementType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.jucmnav.turn.Turn.IntentionalElementType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1607:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1608:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1608:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1609:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1626:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1627:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1627:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1628:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_32); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentionalElementAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:1649:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==39) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTurn.g:1650:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,39,FOLLOW_30); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntentionalElementAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTurn.g:1654:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==104||(LA33_0>=117 && LA33_0<=119)) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==RULE_INT||(LA33_0>=60 && LA33_0<=61)) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalTurn.g:1655:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTurn.g:1655:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTurn.g:1656:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTurn.g:1656:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTurn.g:1657:7: lv_importance_5_0= ruleImportanceType
                            {

                            							newCompositeNode(grammarAccess.getIntentionalElementAccess().getImportanceImportanceTypeEnumRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_33);
                            lv_importance_5_0=ruleImportanceType();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
                            							}
                            							set(
                            								current,
                            								"importance",
                            								lv_importance_5_0,
                            								"org.jucmnav.turn.Turn.ImportanceType");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTurn.g:1675:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:1675:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:1676:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:1676:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTurn.g:1677:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
                            {

                            							newCompositeNode(grammarAccess.getIntentionalElementAccess().getImportanceQuantitativeQuantitativeValueParserRuleCall_4_1_1_0());
                            						
                            pushFollow(FOLLOW_33);
                            lv_importanceQuantitative_6_0=ruleQuantitativeValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
                            							}
                            							set(
                            								current,
                            								"importanceQuantitative",
                            								lv_importanceQuantitative_6_0,
                            								"org.jucmnav.turn.Turn.QuantitativeValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalTurn.g:1696:3: (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==40) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTurn.g:1697:4: otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,40,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntentionalElementAccess().getUnitKeyword_5_0());
                    			
                    // InternalTurn.g:1701:4: ( (lv_unit_8_0= RULE_STRING ) )
                    // InternalTurn.g:1702:5: (lv_unit_8_0= RULE_STRING )
                    {
                    // InternalTurn.g:1702:5: (lv_unit_8_0= RULE_STRING )
                    // InternalTurn.g:1703:6: lv_unit_8_0= RULE_STRING
                    {
                    lv_unit_8_0=(Token)match(input,RULE_STRING,FOLLOW_34); 

                    						newLeafNode(lv_unit_8_0, grammarAccess.getIntentionalElementAccess().getUnitSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIntentionalElementRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"unit",
                    							lv_unit_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:1720:3: ( (lv_linksSrc_9_0= ruleElementLink ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID||LA36_0==41||LA36_0==45||LA36_0==82||LA36_0==84||LA36_0==120) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalTurn.g:1721:4: (lv_linksSrc_9_0= ruleElementLink )
            	    {
            	    // InternalTurn.g:1721:4: (lv_linksSrc_9_0= ruleElementLink )
            	    // InternalTurn.g:1722:5: lv_linksSrc_9_0= ruleElementLink
            	    {

            	    					newCompositeNode(grammarAccess.getIntentionalElementAccess().getLinksSrcElementLinkParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_linksSrc_9_0=ruleElementLink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"linksSrc",
            	    						lv_linksSrc_9_0,
            	    						"org.jucmnav.turn.Turn.ElementLink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_10=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getIntentionalElementAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentionalElement"


    // $ANTLR start "entryRuleElementLink"
    // InternalTurn.g:1747:1: entryRuleElementLink returns [EObject current=null] : iv_ruleElementLink= ruleElementLink EOF ;
    public final EObject entryRuleElementLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementLink = null;


        try {
            // InternalTurn.g:1747:52: (iv_ruleElementLink= ruleElementLink EOF )
            // InternalTurn.g:1748:2: iv_ruleElementLink= ruleElementLink EOF
            {
             newCompositeNode(grammarAccess.getElementLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElementLink=ruleElementLink();

            state._fsp--;

             current =iv_ruleElementLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementLink"


    // $ANTLR start "ruleElementLink"
    // InternalTurn.g:1754:1: ruleElementLink returns [EObject current=null] : (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) ;
    public final EObject ruleElementLink() throws RecognitionException {
        EObject current = null;

        EObject this_Contribution_0 = null;

        EObject this_Decomposition_1 = null;

        EObject this_Dependency_2 = null;



        	enterRule();

        try {
            // InternalTurn.g:1760:2: ( (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) )
            // InternalTurn.g:1761:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            {
            // InternalTurn.g:1761:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            int alt37=3;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // InternalTurn.g:1762:3: this_Contribution_0= ruleContribution
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getContributionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Contribution_0=ruleContribution();

                    state._fsp--;


                    			current = this_Contribution_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:1771:3: this_Decomposition_1= ruleDecomposition
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getDecompositionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Decomposition_1=ruleDecomposition();

                    state._fsp--;


                    			current = this_Decomposition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:1780:3: this_Dependency_2= ruleDependency
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getDependencyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Dependency_2=ruleDependency();

                    state._fsp--;


                    			current = this_Dependency_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElementLink"


    // $ANTLR start "entryRuleContribution"
    // InternalTurn.g:1792:1: entryRuleContribution returns [EObject current=null] : iv_ruleContribution= ruleContribution EOF ;
    public final EObject entryRuleContribution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContribution = null;


        try {
            // InternalTurn.g:1792:53: (iv_ruleContribution= ruleContribution EOF )
            // InternalTurn.g:1793:2: iv_ruleContribution= ruleContribution EOF
            {
             newCompositeNode(grammarAccess.getContributionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContribution=ruleContribution();

            state._fsp--;

             current =iv_ruleContribution; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContribution"


    // $ANTLR start "ruleContribution"
    // InternalTurn.g:1799:1: ruleContribution returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleContribution() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_correlation_4_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        Enumerator lv_contribution_6_0 = null;

        AntlrDatatypeRuleToken lv_quantitativeContribution_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1805:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:1806:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:1806:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:1807:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:1807:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTurn.g:1808:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1808:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1809:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1809:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1810:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:1827:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1828:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1828:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1829:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getContributionAccess().getContributesToKeyword_1());
            		
            // InternalTurn.g:1851:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1852:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1852:4: ( ruleQualifiedName )
            // InternalTurn.g:1853:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getContributionAccess().getDestIntentionalElementCrossReference_2_0());
            				
            pushFollow(FOLLOW_37);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1867:3: ( (lv_correlation_4_0= 'correlated' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==42) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalTurn.g:1868:4: (lv_correlation_4_0= 'correlated' )
                    {
                    // InternalTurn.g:1868:4: (lv_correlation_4_0= 'correlated' )
                    // InternalTurn.g:1869:5: lv_correlation_4_0= 'correlated'
                    {
                    lv_correlation_4_0=(Token)match(input,42,FOLLOW_38); 

                    					newLeafNode(lv_correlation_4_0, grammarAccess.getContributionAccess().getCorrelationCorrelatedKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContributionRule());
                    					}
                    					setWithLastConsumed(current, "correlation", true, "correlated");
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,43,FOLLOW_39); 

            			newLeafNode(otherlv_5, grammarAccess.getContributionAccess().getWithKeyword_4());
            		
            // InternalTurn.g:1885:3: ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==103||(LA40_0>=111 && LA40_0<=116)) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_INT||(LA40_0>=60 && LA40_0<=61)) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalTurn.g:1886:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    {
                    // InternalTurn.g:1886:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    // InternalTurn.g:1887:5: (lv_contribution_6_0= ruleContributionType )
                    {
                    // InternalTurn.g:1887:5: (lv_contribution_6_0= ruleContributionType )
                    // InternalTurn.g:1888:6: lv_contribution_6_0= ruleContributionType
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getContributionContributionTypeEnumRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_contribution_6_0=ruleContributionType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"contribution",
                    							lv_contribution_6_0,
                    							"org.jucmnav.turn.Turn.ContributionType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:1906:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:1906:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:1907:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:1907:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    // InternalTurn.g:1908:6: lv_quantitativeContribution_7_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getQuantitativeContributionQuantitativeValueParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_quantitativeContribution_7_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"quantitativeContribution",
                    							lv_quantitativeContribution_7_0,
                    							"org.jucmnav.turn.Turn.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContribution"


    // $ANTLR start "entryRuleDecomposition"
    // InternalTurn.g:1930:1: entryRuleDecomposition returns [EObject current=null] : iv_ruleDecomposition= ruleDecomposition EOF ;
    public final EObject entryRuleDecomposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecomposition = null;


        try {
            // InternalTurn.g:1930:54: (iv_ruleDecomposition= ruleDecomposition EOF )
            // InternalTurn.g:1931:2: iv_ruleDecomposition= ruleDecomposition EOF
            {
             newCompositeNode(grammarAccess.getDecompositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecomposition=ruleDecomposition();

            state._fsp--;

             current =iv_ruleDecomposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecomposition"


    // $ANTLR start "ruleDecomposition"
    // InternalTurn.g:1937:1: ruleDecomposition returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDecomposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        Enumerator lv_decompositionType_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1943:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:1944:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:1944:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:1945:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:1945:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTurn.g:1946:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1946:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1947:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1947:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1948:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDecompositionAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecompositionRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:1965:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1966:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1966:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1967:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getDecompositionAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecompositionRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:1985:3: ( (lv_decompositionType_2_0= ruleDecompositionType ) )
            // InternalTurn.g:1986:4: (lv_decompositionType_2_0= ruleDecompositionType )
            {
            // InternalTurn.g:1986:4: (lv_decompositionType_2_0= ruleDecompositionType )
            // InternalTurn.g:1987:5: lv_decompositionType_2_0= ruleDecompositionType
            {

            					newCompositeNode(grammarAccess.getDecompositionAccess().getDecompositionTypeDecompositionTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_decompositionType_2_0=ruleDecompositionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDecompositionRule());
            					}
            					set(
            						current,
            						"decompositionType",
            						lv_decompositionType_2_0,
            						"org.jucmnav.turn.Turn.DecompositionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDecompositionAccess().getDecomposesKeyword_2());
            		
            // InternalTurn.g:2008:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:2009:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:2009:4: ( ruleQualifiedName )
            // InternalTurn.g:2010:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDecompositionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDecompositionAccess().getDestIntentionalElementCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecomposition"


    // $ANTLR start "entryRuleDependency"
    // InternalTurn.g:2028:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalTurn.g:2028:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalTurn.g:2029:2: iv_ruleDependency= ruleDependency EOF
            {
             newCompositeNode(grammarAccess.getDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDependency=ruleDependency();

            state._fsp--;

             current =iv_ruleDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDependency"


    // $ANTLR start "ruleDependency"
    // InternalTurn.g:2035:1: ruleDependency returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2041:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:2042:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:2042:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:2043:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:2043:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTurn.g:2044:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:2044:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:2045:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:2045:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:2046:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDependencyAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDependencyRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:2063:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:2064:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:2064:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:2065:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getDependencyAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDependencyRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getDependencyAccess().getDependsOnKeyword_1());
            		
            // InternalTurn.g:2087:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:2088:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:2088:4: ( ruleQualifiedName )
            // InternalTurn.g:2089:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDependencyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDependencyAccess().getDestIntentionalElementCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependency"


    // $ANTLR start "entryRuleStrategiesGroup"
    // InternalTurn.g:2107:1: entryRuleStrategiesGroup returns [EObject current=null] : iv_ruleStrategiesGroup= ruleStrategiesGroup EOF ;
    public final EObject entryRuleStrategiesGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStrategiesGroup = null;


        try {
            // InternalTurn.g:2107:56: (iv_ruleStrategiesGroup= ruleStrategiesGroup EOF )
            // InternalTurn.g:2108:2: iv_ruleStrategiesGroup= ruleStrategiesGroup EOF
            {
             newCompositeNode(grammarAccess.getStrategiesGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStrategiesGroup=ruleStrategiesGroup();

            state._fsp--;

             current =iv_ruleStrategiesGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStrategiesGroup"


    // $ANTLR start "ruleStrategiesGroup"
    // InternalTurn.g:2114:1: ruleStrategiesGroup returns [EObject current=null] : (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
    public final EObject ruleStrategiesGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2120:2: ( (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTurn.g:2121:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTurn.g:2121:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTurn.g:2122:3: otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStrategiesGroupAccess().getStrategiesGroupKeyword_0());
            		
            // InternalTurn.g:2126:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2127:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2127:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2128:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getStrategiesGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStrategiesGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2145:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2146:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2146:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2147:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getStrategiesGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStrategiesGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getStrategiesGroupAccess().getColonKeyword_3());
            		
            // InternalTurn.g:2168:3: ( (otherlv_4= RULE_ID ) )
            // InternalTurn.g:2169:4: (otherlv_4= RULE_ID )
            {
            // InternalTurn.g:2169:4: (otherlv_4= RULE_ID )
            // InternalTurn.g:2170:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStrategiesGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getStrategiesGroupAccess().getEvalStrategyEvaluationStrategyCrossReference_4_0());
            				

            }


            }

            // InternalTurn.g:2181:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==23) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalTurn.g:2182:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getStrategiesGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:2186:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTurn.g:2187:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTurn.g:2187:5: (otherlv_6= RULE_ID )
            	    // InternalTurn.g:2188:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStrategiesGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_16); 

            	    						newLeafNode(otherlv_6, grammarAccess.getStrategiesGroupAccess().getEvalStrategiesEvaluationStrategyCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStrategiesGroup"


    // $ANTLR start "entryRuleEvaluationStrategy"
    // InternalTurn.g:2204:1: entryRuleEvaluationStrategy returns [EObject current=null] : iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF ;
    public final EObject entryRuleEvaluationStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluationStrategy = null;


        try {
            // InternalTurn.g:2204:59: (iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF )
            // InternalTurn.g:2205:2: iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF
            {
             newCompositeNode(grammarAccess.getEvaluationStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluationStrategy=ruleEvaluationStrategy();

            state._fsp--;

             current =iv_ruleEvaluationStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluationStrategy"


    // $ANTLR start "ruleEvaluationStrategy"
    // InternalTurn.g:2211:1: ruleEvaluationStrategy returns [EObject current=null] : (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' ) ;
    public final EObject ruleEvaluationStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_info_4_0 = null;

        EObject lv_evaluations_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2217:2: ( (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' ) )
            // InternalTurn.g:2218:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' )
            {
            // InternalTurn.g:2218:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' )
            // InternalTurn.g:2219:3: otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEvaluationStrategyAccess().getStrategyKeyword_0());
            		
            // InternalTurn.g:2223:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2224:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2224:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2225:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2242:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2243:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2243:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2244:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_45); 

            			newLeafNode(otherlv_3, grammarAccess.getEvaluationStrategyAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:2265:3: ( (lv_info_4_0= ruleConcreteStrategy ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==15) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalTurn.g:2266:4: (lv_info_4_0= ruleConcreteStrategy )
                    {
                    // InternalTurn.g:2266:4: (lv_info_4_0= ruleConcreteStrategy )
                    // InternalTurn.g:2267:5: lv_info_4_0= ruleConcreteStrategy
                    {

                    					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getInfoConcreteStrategyParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_46);
                    lv_info_4_0=ruleConcreteStrategy();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
                    					}
                    					set(
                    						current,
                    						"info",
                    						lv_info_4_0,
                    						"org.jucmnav.turn.Turn.ConcreteStrategy");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:2284:3: ( (lv_evaluations_5_0= ruleEvaluation ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_ID) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalTurn.g:2285:4: (lv_evaluations_5_0= ruleEvaluation )
            	    {
            	    // InternalTurn.g:2285:4: (lv_evaluations_5_0= ruleEvaluation )
            	    // InternalTurn.g:2286:5: lv_evaluations_5_0= ruleEvaluation
            	    {

            	    					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getEvaluationsEvaluationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_46);
            	    lv_evaluations_5_0=ruleEvaluation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"evaluations",
            	    						lv_evaluations_5_0,
            	    						"org.jucmnav.turn.Turn.Evaluation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // InternalTurn.g:2303:3: (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==48) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTurn.g:2304:4: otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,48,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getEvaluationStrategyAccess().getIncludesKeyword_6_0());
                    			
                    // InternalTurn.g:2308:4: ( (otherlv_7= RULE_ID ) )
                    // InternalTurn.g:2309:5: (otherlv_7= RULE_ID )
                    {
                    // InternalTurn.g:2309:5: (otherlv_7= RULE_ID )
                    // InternalTurn.g:2310:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEvaluationStrategyRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_47); 

                    						newLeafNode(otherlv_7, grammarAccess.getEvaluationStrategyAccess().getIncludedStrategyEvaluationStrategyCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:2321:4: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==23) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalTurn.g:2322:5: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getEvaluationStrategyAccess().getCommaKeyword_6_2_0());
                    	    				
                    	    // InternalTurn.g:2326:5: ( (otherlv_9= RULE_ID ) )
                    	    // InternalTurn.g:2327:6: (otherlv_9= RULE_ID )
                    	    {
                    	    // InternalTurn.g:2327:6: (otherlv_9= RULE_ID )
                    	    // InternalTurn.g:2328:7: otherlv_9= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getEvaluationStrategyRule());
                    	    							}
                    	    						
                    	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_47); 

                    	    							newLeafNode(otherlv_9, grammarAccess.getEvaluationStrategyAccess().getIncludedStrategiesEvaluationStrategyCrossReference_6_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getEvaluationStrategyAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluationStrategy"


    // $ANTLR start "entryRuleConcreteStrategy"
    // InternalTurn.g:2349:1: entryRuleConcreteStrategy returns [EObject current=null] : iv_ruleConcreteStrategy= ruleConcreteStrategy EOF ;
    public final EObject entryRuleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteStrategy = null;


        try {
            // InternalTurn.g:2349:57: (iv_ruleConcreteStrategy= ruleConcreteStrategy EOF )
            // InternalTurn.g:2350:2: iv_ruleConcreteStrategy= ruleConcreteStrategy EOF
            {
             newCompositeNode(grammarAccess.getConcreteStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteStrategy=ruleConcreteStrategy();

            state._fsp--;

             current =iv_ruleConcreteStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteStrategy"


    // $ANTLR start "ruleConcreteStrategy"
    // InternalTurn.g:2356:1: ruleConcreteStrategy returns [EObject current=null] : (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_author_1_0=null;


        	enterRule();

        try {
            // InternalTurn.g:2362:2: ( (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) )
            // InternalTurn.g:2363:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            {
            // InternalTurn.g:2363:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            // InternalTurn.g:2364:3: otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteStrategyAccess().getAuthorKeyword_0());
            		
            // InternalTurn.g:2368:3: ( (lv_author_1_0= RULE_STRING ) )
            // InternalTurn.g:2369:4: (lv_author_1_0= RULE_STRING )
            {
            // InternalTurn.g:2369:4: (lv_author_1_0= RULE_STRING )
            // InternalTurn.g:2370:5: lv_author_1_0= RULE_STRING
            {
            lv_author_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_author_1_0, grammarAccess.getConcreteStrategyAccess().getAuthorSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteStrategyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"author",
            						lv_author_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteStrategy"


    // $ANTLR start "entryRuleEvaluation"
    // InternalTurn.g:2390:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalTurn.g:2390:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalTurn.g:2391:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // InternalTurn.g:2397:1: ruleEvaluation returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token lv_exceeds_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Enumerator lv_qualitativeEvaluation_3_0 = null;

        AntlrDatatypeRuleToken lv_evaluation_4_0 = null;

        EObject lv_indicatorEval_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2403:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) )
            // InternalTurn.g:2404:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            {
            // InternalTurn.g:2404:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalTurn.g:2405:3: ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalTurn.g:2405:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:2406:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:2406:4: ( ruleQualifiedName )
            // InternalTurn.g:2407:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEvaluationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEvaluationAccess().getIntElementIntentionalElementCrossReference_0_0());
            				
            pushFollow(FOLLOW_48);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2421:3: ( (lv_exceeds_1_0= 'exceeding' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==49) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalTurn.g:2422:4: (lv_exceeds_1_0= 'exceeding' )
                    {
                    // InternalTurn.g:2422:4: (lv_exceeds_1_0= 'exceeding' )
                    // InternalTurn.g:2423:5: lv_exceeds_1_0= 'exceeding'
                    {
                    lv_exceeds_1_0=(Token)match(input,49,FOLLOW_48); 

                    					newLeafNode(lv_exceeds_1_0, grammarAccess.getEvaluationAccess().getExceedsExceedingKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEvaluationRule());
                    					}
                    					setWithLastConsumed(current, "exceeds", true, "exceeding");
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:2435:3: ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==50) ) {
                alt50=1;
            }
            else if ( (LA50_0==52) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalTurn.g:2436:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    {
                    // InternalTurn.g:2436:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    // InternalTurn.g:2437:5: otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_49); 

                    					newLeafNode(otherlv_2, grammarAccess.getEvaluationAccess().getEvaluationKeyword_2_0_0());
                    				
                    // InternalTurn.g:2441:5: ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( ((LA49_0>=98 && LA49_0<=104)) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==RULE_INT||(LA49_0>=60 && LA49_0<=61)) ) {
                        alt49=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalTurn.g:2442:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            {
                            // InternalTurn.g:2442:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            // InternalTurn.g:2443:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            {
                            // InternalTurn.g:2443:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            // InternalTurn.g:2444:8: lv_qualitativeEvaluation_3_0= ruleQualitativeLabel
                            {

                            								newCompositeNode(grammarAccess.getEvaluationAccess().getQualitativeEvaluationQualitativeLabelEnumRuleCall_2_0_1_0_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_qualitativeEvaluation_3_0=ruleQualitativeLabel();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getEvaluationRule());
                            								}
                            								set(
                            									current,
                            									"qualitativeEvaluation",
                            									lv_qualitativeEvaluation_3_0,
                            									"org.jucmnav.turn.Turn.QualitativeLabel");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTurn.g:2462:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:2462:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:2463:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:2463:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            // InternalTurn.g:2464:8: lv_evaluation_4_0= ruleQuantitativeValue
                            {

                            								newCompositeNode(grammarAccess.getEvaluationAccess().getEvaluationQuantitativeValueParserRuleCall_2_0_1_1_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_evaluation_4_0=ruleQuantitativeValue();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getEvaluationRule());
                            								}
                            								set(
                            									current,
                            									"evaluation",
                            									lv_evaluation_4_0,
                            									"org.jucmnav.turn.Turn.QuantitativeValue");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:2484:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalTurn.g:2484:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    // InternalTurn.g:2485:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalTurn.g:2485:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) )
                    // InternalTurn.g:2486:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    {
                    // InternalTurn.g:2486:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    // InternalTurn.g:2487:7: lv_indicatorEval_5_0= ruleIndicatorEvaluation
                    {

                    							newCompositeNode(grammarAccess.getEvaluationAccess().getIndicatorEvalIndicatorEvaluationParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FOLLOW_50);
                    lv_indicatorEval_5_0=ruleIndicatorEvaluation();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getEvaluationRule());
                    							}
                    							set(
                    								current,
                    								"indicatorEval",
                    								lv_indicatorEval_5_0,
                    								"org.jucmnav.turn.Turn.IndicatorEvaluation");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_6=(Token)match(input,51,FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getEvaluationAccess().getConvertedWithKeyword_2_1_1());
                    				
                    // InternalTurn.g:2508:5: ( (otherlv_7= RULE_ID ) )
                    // InternalTurn.g:2509:6: (otherlv_7= RULE_ID )
                    {
                    // InternalTurn.g:2509:6: (otherlv_7= RULE_ID )
                    // InternalTurn.g:2510:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEvaluationRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_7, grammarAccess.getEvaluationAccess().getConversionIndicatorConversionCrossReference_2_1_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleIndicatorEvaluation"
    // InternalTurn.g:2527:1: entryRuleIndicatorEvaluation returns [EObject current=null] : iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF ;
    public final EObject entryRuleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorEvaluation = null;


        try {
            // InternalTurn.g:2527:60: (iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF )
            // InternalTurn.g:2528:2: iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF
            {
             newCompositeNode(grammarAccess.getIndicatorEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIndicatorEvaluation=ruleIndicatorEvaluation();

            state._fsp--;

             current =iv_ruleIndicatorEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndicatorEvaluation"


    // $ANTLR start "ruleIndicatorEvaluation"
    // InternalTurn.g:2534:1: ruleIndicatorEvaluation returns [EObject current=null] : (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) ;
    public final EObject ruleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_realWorldLabel_1_0=null;
        Token lv_realWorldValue_2_0=null;


        	enterRule();

        try {
            // InternalTurn.g:2540:2: ( (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) )
            // InternalTurn.g:2541:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            {
            // InternalTurn.g:2541:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            // InternalTurn.g:2542:3: otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getIndicatorEvaluationAccess().getRealKeyword_0());
            		
            // InternalTurn.g:2546:3: ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_STRING) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_INT) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalTurn.g:2547:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    {
                    // InternalTurn.g:2547:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    // InternalTurn.g:2548:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    {
                    // InternalTurn.g:2548:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    // InternalTurn.g:2549:6: lv_realWorldLabel_1_0= RULE_STRING
                    {
                    lv_realWorldLabel_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_realWorldLabel_1_0, grammarAccess.getIndicatorEvaluationAccess().getRealWorldLabelSTRINGTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIndicatorEvaluationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"realWorldLabel",
                    							lv_realWorldLabel_1_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:2566:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    {
                    // InternalTurn.g:2566:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    // InternalTurn.g:2567:5: (lv_realWorldValue_2_0= RULE_INT )
                    {
                    // InternalTurn.g:2567:5: (lv_realWorldValue_2_0= RULE_INT )
                    // InternalTurn.g:2568:6: lv_realWorldValue_2_0= RULE_INT
                    {
                    lv_realWorldValue_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_realWorldValue_2_0, grammarAccess.getIndicatorEvaluationAccess().getRealWorldValueINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIndicatorEvaluationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"realWorldValue",
                    							lv_realWorldValue_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndicatorEvaluation"


    // $ANTLR start "entryRuleIndicatorConversion"
    // InternalTurn.g:2589:1: entryRuleIndicatorConversion returns [EObject current=null] : iv_ruleIndicatorConversion= ruleIndicatorConversion EOF ;
    public final EObject entryRuleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorConversion = null;


        try {
            // InternalTurn.g:2589:60: (iv_ruleIndicatorConversion= ruleIndicatorConversion EOF )
            // InternalTurn.g:2590:2: iv_ruleIndicatorConversion= ruleIndicatorConversion EOF
            {
             newCompositeNode(grammarAccess.getIndicatorConversionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIndicatorConversion=ruleIndicatorConversion();

            state._fsp--;

             current =iv_ruleIndicatorConversion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndicatorConversion"


    // $ANTLR start "ruleIndicatorConversion"
    // InternalTurn.g:2596:1: ruleIndicatorConversion returns [EObject current=null] : (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) ;
    public final EObject ruleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject this_LinearConversion_0 = null;

        EObject this_QualToQMappings_1 = null;



        	enterRule();

        try {
            // InternalTurn.g:2602:2: ( (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) )
            // InternalTurn.g:2603:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            {
            // InternalTurn.g:2603:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==53) ) {
                alt52=1;
            }
            else if ( (LA52_0==57) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalTurn.g:2604:3: this_LinearConversion_0= ruleLinearConversion
                    {

                    			newCompositeNode(grammarAccess.getIndicatorConversionAccess().getLinearConversionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LinearConversion_0=ruleLinearConversion();

                    state._fsp--;


                    			current = this_LinearConversion_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:2613:3: this_QualToQMappings_1= ruleQualToQMappings
                    {

                    			newCompositeNode(grammarAccess.getIndicatorConversionAccess().getQualToQMappingsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_QualToQMappings_1=ruleQualToQMappings();

                    state._fsp--;


                    			current = this_QualToQMappings_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndicatorConversion"


    // $ANTLR start "entryRuleLinearConversion"
    // InternalTurn.g:2625:1: entryRuleLinearConversion returns [EObject current=null] : iv_ruleLinearConversion= ruleLinearConversion EOF ;
    public final EObject entryRuleLinearConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinearConversion = null;


        try {
            // InternalTurn.g:2625:57: (iv_ruleLinearConversion= ruleLinearConversion EOF )
            // InternalTurn.g:2626:2: iv_ruleLinearConversion= ruleLinearConversion EOF
            {
             newCompositeNode(grammarAccess.getLinearConversionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLinearConversion=ruleLinearConversion();

            state._fsp--;

             current =iv_ruleLinearConversion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinearConversion"


    // $ANTLR start "ruleLinearConversion"
    // InternalTurn.g:2632:1: ruleLinearConversion returns [EObject current=null] : (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) ;
    public final EObject ruleLinearConversion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_unit_5_0=null;
        Token otherlv_6=null;
        Token lv_targetValue_7_0=null;
        Token otherlv_8=null;
        Token lv_thresholdValue_9_0=null;
        Token otherlv_10=null;
        Token lv_worstValue_11_0=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2638:2: ( (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) )
            // InternalTurn.g:2639:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            {
            // InternalTurn.g:2639:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            // InternalTurn.g:2640:3: otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLinearConversionAccess().getLinearConversionKeyword_0());
            		
            // InternalTurn.g:2644:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2645:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2645:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2646:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLinearConversionAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLinearConversionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2663:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2664:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2664:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2665:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getLinearConversionAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLinearConversionRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getLinearConversionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,40,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getLinearConversionAccess().getUnitKeyword_4());
            		
            // InternalTurn.g:2690:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTurn.g:2691:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTurn.g:2691:4: (lv_unit_5_0= RULE_STRING )
            // InternalTurn.g:2692:5: lv_unit_5_0= RULE_STRING
            {
            lv_unit_5_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

            					newLeafNode(lv_unit_5_0, grammarAccess.getLinearConversionAccess().getUnitSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unit",
            						lv_unit_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,54,FOLLOW_54); 

            			newLeafNode(otherlv_6, grammarAccess.getLinearConversionAccess().getTargetKeyword_6());
            		
            // InternalTurn.g:2712:3: ( (lv_targetValue_7_0= RULE_INT ) )
            // InternalTurn.g:2713:4: (lv_targetValue_7_0= RULE_INT )
            {
            // InternalTurn.g:2713:4: (lv_targetValue_7_0= RULE_INT )
            // InternalTurn.g:2714:5: lv_targetValue_7_0= RULE_INT
            {
            lv_targetValue_7_0=(Token)match(input,RULE_INT,FOLLOW_55); 

            					newLeafNode(lv_targetValue_7_0, grammarAccess.getLinearConversionAccess().getTargetValueINTTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"targetValue",
            						lv_targetValue_7_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_8=(Token)match(input,55,FOLLOW_54); 

            			newLeafNode(otherlv_8, grammarAccess.getLinearConversionAccess().getThresholdKeyword_8());
            		
            // InternalTurn.g:2734:3: ( (lv_thresholdValue_9_0= RULE_INT ) )
            // InternalTurn.g:2735:4: (lv_thresholdValue_9_0= RULE_INT )
            {
            // InternalTurn.g:2735:4: (lv_thresholdValue_9_0= RULE_INT )
            // InternalTurn.g:2736:5: lv_thresholdValue_9_0= RULE_INT
            {
            lv_thresholdValue_9_0=(Token)match(input,RULE_INT,FOLLOW_56); 

            					newLeafNode(lv_thresholdValue_9_0, grammarAccess.getLinearConversionAccess().getThresholdValueINTTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"thresholdValue",
            						lv_thresholdValue_9_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_10=(Token)match(input,56,FOLLOW_54); 

            			newLeafNode(otherlv_10, grammarAccess.getLinearConversionAccess().getWorstKeyword_10());
            		
            // InternalTurn.g:2756:3: ( (lv_worstValue_11_0= RULE_INT ) )
            // InternalTurn.g:2757:4: (lv_worstValue_11_0= RULE_INT )
            {
            // InternalTurn.g:2757:4: (lv_worstValue_11_0= RULE_INT )
            // InternalTurn.g:2758:5: lv_worstValue_11_0= RULE_INT
            {
            lv_worstValue_11_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            					newLeafNode(lv_worstValue_11_0, grammarAccess.getLinearConversionAccess().getWorstValueINTTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"worstValue",
            						lv_worstValue_11_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_12=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getLinearConversionAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinearConversion"


    // $ANTLR start "entryRuleQualToQMappings"
    // InternalTurn.g:2782:1: entryRuleQualToQMappings returns [EObject current=null] : iv_ruleQualToQMappings= ruleQualToQMappings EOF ;
    public final EObject entryRuleQualToQMappings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMappings = null;


        try {
            // InternalTurn.g:2782:56: (iv_ruleQualToQMappings= ruleQualToQMappings EOF )
            // InternalTurn.g:2783:2: iv_ruleQualToQMappings= ruleQualToQMappings EOF
            {
             newCompositeNode(grammarAccess.getQualToQMappingsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualToQMappings=ruleQualToQMappings();

            state._fsp--;

             current =iv_ruleQualToQMappings; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualToQMappings"


    // $ANTLR start "ruleQualToQMappings"
    // InternalTurn.g:2789:1: ruleQualToQMappings returns [EObject current=null] : (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) ;
    public final EObject ruleQualToQMappings() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_unit_5_0=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_mappings_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2795:2: ( (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) )
            // InternalTurn.g:2796:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            {
            // InternalTurn.g:2796:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            // InternalTurn.g:2797:3: otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getQualToQMappingsAccess().getMappingConversionKeyword_0());
            		
            // InternalTurn.g:2801:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2802:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2802:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2803:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2820:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2821:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2821:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2822:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getQualToQMappingsAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,40,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getQualToQMappingsAccess().getUnitKeyword_4());
            		
            // InternalTurn.g:2847:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTurn.g:2848:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTurn.g:2848:4: (lv_unit_5_0= RULE_STRING )
            // InternalTurn.g:2849:5: lv_unit_5_0= RULE_STRING
            {
            lv_unit_5_0=(Token)match(input,RULE_STRING,FOLLOW_57); 

            					newLeafNode(lv_unit_5_0, grammarAccess.getQualToQMappingsAccess().getUnitSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualToQMappingsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unit",
            						lv_unit_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTurn.g:2865:3: ( (lv_mappings_6_0= ruleQualToQMapping ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==49||LA53_0==52) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalTurn.g:2866:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    {
            	    // InternalTurn.g:2866:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    // InternalTurn.g:2867:5: lv_mappings_6_0= ruleQualToQMapping
            	    {

            	    					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getMappingsQualToQMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_58);
            	    lv_mappings_6_0=ruleQualToQMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mappings",
            	    						lv_mappings_6_0,
            	    						"org.jucmnav.turn.Turn.QualToQMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            otherlv_7=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getQualToQMappingsAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualToQMappings"


    // $ANTLR start "entryRuleQualToQMapping"
    // InternalTurn.g:2892:1: entryRuleQualToQMapping returns [EObject current=null] : iv_ruleQualToQMapping= ruleQualToQMapping EOF ;
    public final EObject entryRuleQualToQMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMapping = null;


        try {
            // InternalTurn.g:2892:55: (iv_ruleQualToQMapping= ruleQualToQMapping EOF )
            // InternalTurn.g:2893:2: iv_ruleQualToQMapping= ruleQualToQMapping EOF
            {
             newCompositeNode(grammarAccess.getQualToQMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualToQMapping=ruleQualToQMapping();

            state._fsp--;

             current =iv_ruleQualToQMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualToQMapping"


    // $ANTLR start "ruleQualToQMapping"
    // InternalTurn.g:2899:1: ruleQualToQMapping returns [EObject current=null] : ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleQualToQMapping() throws RecognitionException {
        EObject current = null;

        Token lv_exceeds_0_0=null;
        Token otherlv_1=null;
        Token lv_realWorldLabel_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_qualitativeEvaluation_4_0 = null;

        AntlrDatatypeRuleToken lv_evaluation_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2905:2: ( ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:2906:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:2906:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:2907:3: ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:2907:3: ( (lv_exceeds_0_0= 'exceeding' ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==49) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalTurn.g:2908:4: (lv_exceeds_0_0= 'exceeding' )
                    {
                    // InternalTurn.g:2908:4: (lv_exceeds_0_0= 'exceeding' )
                    // InternalTurn.g:2909:5: lv_exceeds_0_0= 'exceeding'
                    {
                    lv_exceeds_0_0=(Token)match(input,49,FOLLOW_59); 

                    					newLeafNode(lv_exceeds_0_0, grammarAccess.getQualToQMappingAccess().getExceedsExceedingKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQualToQMappingRule());
                    					}
                    					setWithLastConsumed(current, "exceeds", true, "exceeding");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,52,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getQualToQMappingAccess().getRealKeyword_1());
            		
            // InternalTurn.g:2925:3: ( (lv_realWorldLabel_2_0= RULE_STRING ) )
            // InternalTurn.g:2926:4: (lv_realWorldLabel_2_0= RULE_STRING )
            {
            // InternalTurn.g:2926:4: (lv_realWorldLabel_2_0= RULE_STRING )
            // InternalTurn.g:2927:5: lv_realWorldLabel_2_0= RULE_STRING
            {
            lv_realWorldLabel_2_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_realWorldLabel_2_0, grammarAccess.getQualToQMappingAccess().getRealWorldLabelSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualToQMappingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"realWorldLabel",
            						lv_realWorldLabel_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getQualToQMappingAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalTurn.g:2947:3: ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=98 && LA55_0<=104)) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_INT||(LA55_0>=60 && LA55_0<=61)) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalTurn.g:2948:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    {
                    // InternalTurn.g:2948:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    // InternalTurn.g:2949:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    {
                    // InternalTurn.g:2949:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    // InternalTurn.g:2950:6: lv_qualitativeEvaluation_4_0= ruleQualitativeLabel
                    {

                    						newCompositeNode(grammarAccess.getQualToQMappingAccess().getQualitativeEvaluationQualitativeLabelEnumRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_qualitativeEvaluation_4_0=ruleQualitativeLabel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQualToQMappingRule());
                    						}
                    						set(
                    							current,
                    							"qualitativeEvaluation",
                    							lv_qualitativeEvaluation_4_0,
                    							"org.jucmnav.turn.Turn.QualitativeLabel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:2968:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:2968:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:2969:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:2969:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    // InternalTurn.g:2970:6: lv_evaluation_5_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getQualToQMappingAccess().getEvaluationQuantitativeValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_evaluation_5_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQualToQMappingRule());
                    						}
                    						set(
                    							current,
                    							"evaluation",
                    							lv_evaluation_5_0,
                    							"org.jucmnav.turn.Turn.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualToQMapping"


    // $ANTLR start "entryRuleContributionContextGroup"
    // InternalTurn.g:2992:1: entryRuleContributionContextGroup returns [EObject current=null] : iv_ruleContributionContextGroup= ruleContributionContextGroup EOF ;
    public final EObject entryRuleContributionContextGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContextGroup = null;


        try {
            // InternalTurn.g:2992:65: (iv_ruleContributionContextGroup= ruleContributionContextGroup EOF )
            // InternalTurn.g:2993:2: iv_ruleContributionContextGroup= ruleContributionContextGroup EOF
            {
             newCompositeNode(grammarAccess.getContributionContextGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionContextGroup=ruleContributionContextGroup();

            state._fsp--;

             current =iv_ruleContributionContextGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionContextGroup"


    // $ANTLR start "ruleContributionContextGroup"
    // InternalTurn.g:2999:1: ruleContributionContextGroup returns [EObject current=null] : (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
    public final EObject ruleContributionContextGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3005:2: ( (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTurn.g:3006:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTurn.g:3006:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTurn.g:3007:3: otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextGroupAccess().getContributionContextGroupKeyword_0());
            		
            // InternalTurn.g:3011:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:3012:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:3012:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:3013:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getContributionContextGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:3030:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:3031:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:3031:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:3032:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getContributionContextGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getContributionContextGroupAccess().getColonKeyword_3());
            		
            // InternalTurn.g:3053:3: ( (otherlv_4= RULE_ID ) )
            // InternalTurn.g:3054:4: (otherlv_4= RULE_ID )
            {
            // InternalTurn.g:3054:4: (otherlv_4= RULE_ID )
            // InternalTurn.g:3055:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionContextGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getContributionContextGroupAccess().getContribContributionContextCrossReference_4_0());
            				

            }


            }

            // InternalTurn.g:3066:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==23) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalTurn.g:3067:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getContributionContextGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:3071:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTurn.g:3072:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTurn.g:3072:5: (otherlv_6= RULE_ID )
            	    // InternalTurn.g:3073:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContributionContextGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_16); 

            	    						newLeafNode(otherlv_6, grammarAccess.getContributionContextGroupAccess().getContribsContributionContextCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionContextGroup"


    // $ANTLR start "entryRuleContributionContext"
    // InternalTurn.g:3089:1: entryRuleContributionContext returns [EObject current=null] : iv_ruleContributionContext= ruleContributionContext EOF ;
    public final EObject entryRuleContributionContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContext = null;


        try {
            // InternalTurn.g:3089:60: (iv_ruleContributionContext= ruleContributionContext EOF )
            // InternalTurn.g:3090:2: iv_ruleContributionContext= ruleContributionContext EOF
            {
             newCompositeNode(grammarAccess.getContributionContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionContext=ruleContributionContext();

            state._fsp--;

             current =iv_ruleContributionContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionContext"


    // $ANTLR start "ruleContributionContext"
    // InternalTurn.g:3096:1: ruleContributionContext returns [EObject current=null] : (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleContributionContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_changes_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3102:2: ( (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' ) )
            // InternalTurn.g:3103:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' )
            {
            // InternalTurn.g:3103:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' )
            // InternalTurn.g:3104:3: otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextAccess().getContributionContextKeyword_0());
            		
            // InternalTurn.g:3108:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:3109:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:3109:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:3110:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getContributionContextAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:3127:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:3128:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:3128:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:3129:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getContributionContextAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_46); 

            			newLeafNode(otherlv_3, grammarAccess.getContributionContextAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:3150:3: ( (lv_changes_4_0= ruleContributionChange ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalTurn.g:3151:4: (lv_changes_4_0= ruleContributionChange )
            	    {
            	    // InternalTurn.g:3151:4: (lv_changes_4_0= ruleContributionChange )
            	    // InternalTurn.g:3152:5: lv_changes_4_0= ruleContributionChange
            	    {

            	    					newCompositeNode(grammarAccess.getContributionContextAccess().getChangesContributionChangeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_46);
            	    lv_changes_4_0=ruleContributionChange();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"changes",
            	    						lv_changes_4_0,
            	    						"org.jucmnav.turn.Turn.ContributionChange");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // InternalTurn.g:3169:3: (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==48) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalTurn.g:3170:4: otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )*
                    {
                    otherlv_5=(Token)match(input,48,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getContributionContextAccess().getIncludesKeyword_5_0());
                    			
                    // InternalTurn.g:3174:4: ( (otherlv_6= RULE_ID ) )
                    // InternalTurn.g:3175:5: (otherlv_6= RULE_ID )
                    {
                    // InternalTurn.g:3175:5: (otherlv_6= RULE_ID )
                    // InternalTurn.g:3176:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContributionContextRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_47); 

                    						newLeafNode(otherlv_6, grammarAccess.getContributionContextAccess().getIncludedContextContributionContextCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:3187:4: (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==23) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalTurn.g:3188:5: otherlv_7= ',' ( (otherlv_8= RULE_ID ) )
                    	    {
                    	    otherlv_7=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getContributionContextAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalTurn.g:3192:5: ( (otherlv_8= RULE_ID ) )
                    	    // InternalTurn.g:3193:6: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalTurn.g:3193:6: (otherlv_8= RULE_ID )
                    	    // InternalTurn.g:3194:7: otherlv_8= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getContributionContextRule());
                    	    							}
                    	    						
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_47); 

                    	    							newLeafNode(otherlv_8, grammarAccess.getContributionContextAccess().getIncludedContextsContributionContextCrossReference_5_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getContributionContextAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionContext"


    // $ANTLR start "entryRuleContributionChange"
    // InternalTurn.g:3215:1: entryRuleContributionChange returns [EObject current=null] : iv_ruleContributionChange= ruleContributionChange EOF ;
    public final EObject entryRuleContributionChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionChange = null;


        try {
            // InternalTurn.g:3215:59: (iv_ruleContributionChange= ruleContributionChange EOF )
            // InternalTurn.g:3216:2: iv_ruleContributionChange= ruleContributionChange EOF
            {
             newCompositeNode(grammarAccess.getContributionChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionChange=ruleContributionChange();

            state._fsp--;

             current =iv_ruleContributionChange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionChange"


    // $ANTLR start "ruleContributionChange"
    // InternalTurn.g:3222:1: ruleContributionChange returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleContributionChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_newContribution_2_0 = null;

        AntlrDatatypeRuleToken lv_newQuantitativeContribution_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3228:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:3229:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:3229:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:3230:3: ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:3230:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:3231:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:3231:4: ( ruleQualifiedName )
            // InternalTurn.g:3232:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionChangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getContributionChangeAccess().getContributionContributionCrossReference_0_0());
            				
            pushFollow(FOLLOW_38);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,43,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getContributionChangeAccess().getWithKeyword_1());
            		
            // InternalTurn.g:3250:3: ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==103||(LA60_0>=111 && LA60_0<=116)) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_INT||(LA60_0>=60 && LA60_0<=61)) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalTurn.g:3251:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    {
                    // InternalTurn.g:3251:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    // InternalTurn.g:3252:5: (lv_newContribution_2_0= ruleContributionType )
                    {
                    // InternalTurn.g:3252:5: (lv_newContribution_2_0= ruleContributionType )
                    // InternalTurn.g:3253:6: lv_newContribution_2_0= ruleContributionType
                    {

                    						newCompositeNode(grammarAccess.getContributionChangeAccess().getNewContributionContributionTypeEnumRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_newContribution_2_0=ruleContributionType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionChangeRule());
                    						}
                    						set(
                    							current,
                    							"newContribution",
                    							lv_newContribution_2_0,
                    							"org.jucmnav.turn.Turn.ContributionType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:3271:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:3271:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:3272:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:3272:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    // InternalTurn.g:3273:6: lv_newQuantitativeContribution_3_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getContributionChangeAccess().getNewQuantitativeContributionQuantitativeValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_newQuantitativeContribution_3_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionChangeRule());
                    						}
                    						set(
                    							current,
                    							"newQuantitativeContribution",
                    							lv_newQuantitativeContribution_3_0,
                    							"org.jucmnav.turn.Turn.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionChange"


    // $ANTLR start "entryRuleQuantitativeValue"
    // InternalTurn.g:3295:1: entryRuleQuantitativeValue returns [String current=null] : iv_ruleQuantitativeValue= ruleQuantitativeValue EOF ;
    public final String entryRuleQuantitativeValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQuantitativeValue = null;


        try {
            // InternalTurn.g:3295:57: (iv_ruleQuantitativeValue= ruleQuantitativeValue EOF )
            // InternalTurn.g:3296:2: iv_ruleQuantitativeValue= ruleQuantitativeValue EOF
            {
             newCompositeNode(grammarAccess.getQuantitativeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuantitativeValue=ruleQuantitativeValue();

            state._fsp--;

             current =iv_ruleQuantitativeValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuantitativeValue"


    // $ANTLR start "ruleQuantitativeValue"
    // InternalTurn.g:3302:1: ruleQuantitativeValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleQuantitativeValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalTurn.g:3308:2: ( ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) )
            // InternalTurn.g:3309:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            {
            // InternalTurn.g:3309:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            // InternalTurn.g:3310:3: (kw= '-' | kw= '+' )? this_INT_2= RULE_INT
            {
            // InternalTurn.g:3310:3: (kw= '-' | kw= '+' )?
            int alt61=3;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==60) ) {
                alt61=1;
            }
            else if ( (LA61_0==61) ) {
                alt61=2;
            }
            switch (alt61) {
                case 1 :
                    // InternalTurn.g:3311:4: kw= '-'
                    {
                    kw=(Token)match(input,60,FOLLOW_54); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQuantitativeValueAccess().getHyphenMinusKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTurn.g:3317:4: kw= '+'
                    {
                    kw=(Token)match(input,61,FOLLOW_54); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQuantitativeValueAccess().getPlusSignKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getQuantitativeValueAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuantitativeValue"


    // $ANTLR start "entryRuleUCMmap"
    // InternalTurn.g:3334:1: entryRuleUCMmap returns [EObject current=null] : iv_ruleUCMmap= ruleUCMmap EOF ;
    public final EObject entryRuleUCMmap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCMmap = null;


        try {
            // InternalTurn.g:3334:47: (iv_ruleUCMmap= ruleUCMmap EOF )
            // InternalTurn.g:3335:2: iv_ruleUCMmap= ruleUCMmap EOF
            {
             newCompositeNode(grammarAccess.getUCMmapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCMmap=ruleUCMmap();

            state._fsp--;

             current =iv_ruleUCMmap; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCMmap"


    // $ANTLR start "ruleUCMmap"
    // InternalTurn.g:3341:1: ruleUCMmap returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) ;
    public final EObject ruleUCMmap() throws RecognitionException {
        EObject current = null;

        Token lv_singleton_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_stubs_5_0 = null;

        EObject lv_paths_6_0 = null;

        EObject lv_components_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3347:2: ( ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) )
            // InternalTurn.g:3348:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            {
            // InternalTurn.g:3348:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            // InternalTurn.g:3349:3: ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}'
            {
            // InternalTurn.g:3349:3: ( (lv_singleton_0_0= 'singleton' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==62) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalTurn.g:3350:4: (lv_singleton_0_0= 'singleton' )
                    {
                    // InternalTurn.g:3350:4: (lv_singleton_0_0= 'singleton' )
                    // InternalTurn.g:3351:5: lv_singleton_0_0= 'singleton'
                    {
                    lv_singleton_0_0=(Token)match(input,62,FOLLOW_60); 

                    					newLeafNode(lv_singleton_0_0, grammarAccess.getUCMmapAccess().getSingletonSingletonKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUCMmapRule());
                    					}
                    					setWithLastConsumed(current, "singleton", true, "singleton");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,63,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getUCMmapAccess().getMapKeyword_1());
            		
            // InternalTurn.g:3367:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:3368:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:3368:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:3369:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getUCMmapAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:3386:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:3387:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:3387:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:3388:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getUCMmapAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_61); 

            			newLeafNode(otherlv_4, grammarAccess.getUCMmapAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalTurn.g:3409:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*
            loop63:
            do {
                int alt63=2;
                alt63 = dfa63.predict(input);
                switch (alt63) {
            	case 1 :
            	    // InternalTurn.g:3410:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    {
            	    // InternalTurn.g:3410:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    // InternalTurn.g:3411:5: lv_stubs_5_0= ruleStubDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getStubsStubDeclarationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_61);
            	    lv_stubs_5_0=ruleStubDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stubs",
            	    						lv_stubs_5_0,
            	    						"org.jucmnav.turn.Turn.StubDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            // InternalTurn.g:3428:3: ( (lv_paths_6_0= rulePath ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==64||(LA64_0>=128 && LA64_0<=129)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalTurn.g:3429:4: (lv_paths_6_0= rulePath )
            	    {
            	    // InternalTurn.g:3429:4: (lv_paths_6_0= rulePath )
            	    // InternalTurn.g:3430:5: lv_paths_6_0= rulePath
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getPathsPathParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_61);
            	    lv_paths_6_0=rulePath();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"paths",
            	    						lv_paths_6_0,
            	    						"org.jucmnav.turn.Turn.Path");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            // InternalTurn.g:3447:3: ( (lv_components_7_0= ruleComponentRef ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ID||LA65_0==38||LA65_0==90||(LA65_0>=123 && LA65_0<=127)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalTurn.g:3448:4: (lv_components_7_0= ruleComponentRef )
            	    {
            	    // InternalTurn.g:3448:4: (lv_components_7_0= ruleComponentRef )
            	    // InternalTurn.g:3449:5: lv_components_7_0= ruleComponentRef
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getComponentsComponentRefParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_62);
            	    lv_components_7_0=ruleComponentRef();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"components",
            	    						lv_components_7_0,
            	    						"org.jucmnav.turn.Turn.ComponentRef");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getUCMmapAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCMmap"


    // $ANTLR start "entryRulePath"
    // InternalTurn.g:3474:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalTurn.g:3474:45: (iv_rulePath= rulePath EOF )
            // InternalTurn.g:3475:2: iv_rulePath= rulePath EOF
            {
             newCompositeNode(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;

             current =iv_rulePath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalTurn.g:3481:1: rulePath returns [EObject current=null] : ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        EObject lv_startPoint_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3487:2: ( ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTurn.g:3488:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTurn.g:3488:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTurn.g:3489:3: ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTurn.g:3489:3: ( (lv_startPoint_0_0= ruleStartPoint ) )
            // InternalTurn.g:3490:4: (lv_startPoint_0_0= ruleStartPoint )
            {
            // InternalTurn.g:3490:4: (lv_startPoint_0_0= ruleStartPoint )
            // InternalTurn.g:3491:5: lv_startPoint_0_0= ruleStartPoint
            {

            					newCompositeNode(grammarAccess.getPathAccess().getStartPointStartPointParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_63);
            lv_startPoint_0_0=ruleStartPoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathRule());
            					}
            					set(
            						current,
            						"startPoint",
            						lv_startPoint_0_0,
            						"org.jucmnav.turn.Turn.StartPoint");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:3508:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTurn.g:3509:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTurn.g:3509:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTurn.g:3510:5: lv_pathBody_1_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getPathAccess().getPathBodyPathBodyParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_pathBody_1_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathRule());
            					}
            					set(
            						current,
            						"pathBody",
            						lv_pathBody_1_0,
            						"org.jucmnav.turn.Turn.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleStartPoint"
    // InternalTurn.g:3531:1: entryRuleStartPoint returns [EObject current=null] : iv_ruleStartPoint= ruleStartPoint EOF ;
    public final EObject entryRuleStartPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartPoint = null;


        try {
            // InternalTurn.g:3531:51: (iv_ruleStartPoint= ruleStartPoint EOF )
            // InternalTurn.g:3532:2: iv_ruleStartPoint= ruleStartPoint EOF
            {
             newCompositeNode(grammarAccess.getStartPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartPoint=ruleStartPoint();

            state._fsp--;

             current =iv_ruleStartPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartPoint"


    // $ANTLR start "ruleStartPoint"
    // InternalTurn.g:3538:1: ruleStartPoint returns [EObject current=null] : ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) ) ;
    public final EObject ruleStartPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_catches_9_0=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_precondition_3_0 = null;

        Enumerator lv_failKind_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_longName_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3544:2: ( ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) ) )
            // InternalTurn.g:3545:2: ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) )
            {
            // InternalTurn.g:3545:2: ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==64) ) {
                alt69=1;
            }
            else if ( ((LA69_0>=128 && LA69_0<=129)) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalTurn.g:3546:3: (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? )
                    {
                    // InternalTurn.g:3546:3: (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? )
                    // InternalTurn.g:3547:4: otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )?
                    {
                    otherlv_0=(Token)match(input,64,FOLLOW_64); 

                    				newLeafNode(otherlv_0, grammarAccess.getStartPointAccess().getStartKeyword_0_0());
                    			
                    // InternalTurn.g:3551:4: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==RULE_ID) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // InternalTurn.g:3552:5: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                            {
                            // InternalTurn.g:3552:5: ( (lv_name_1_0= ruleQualifiedName ) )
                            // InternalTurn.g:3553:6: (lv_name_1_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:3553:6: (lv_name_1_0= ruleQualifiedName )
                            // InternalTurn.g:3554:7: lv_name_1_0= ruleQualifiedName
                            {

                            							newCompositeNode(grammarAccess.getStartPointAccess().getNameQualifiedNameParserRuleCall_0_1_0_0());
                            						
                            pushFollow(FOLLOW_65);
                            lv_name_1_0=ruleQualifiedName();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getStartPointRule());
                            							}
                            							set(
                            								current,
                            								"name",
                            								lv_name_1_0,
                            								"org.jucmnav.turn.Turn.QualifiedName");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalTurn.g:3571:5: ( (lv_longName_2_0= ruleLongName ) )
                            // InternalTurn.g:3572:6: (lv_longName_2_0= ruleLongName )
                            {
                            // InternalTurn.g:3572:6: (lv_longName_2_0= ruleLongName )
                            // InternalTurn.g:3573:7: lv_longName_2_0= ruleLongName
                            {

                            							newCompositeNode(grammarAccess.getStartPointAccess().getLongNameLongNameParserRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_66);
                            lv_longName_2_0=ruleLongName();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getStartPointRule());
                            							}
                            							set(
                            								current,
                            								"longName",
                            								lv_longName_2_0,
                            								"org.jucmnav.turn.Turn.LongName");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalTurn.g:3591:4: ( (lv_precondition_3_0= ruleCondition ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==24) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalTurn.g:3592:5: (lv_precondition_3_0= ruleCondition )
                            {
                            // InternalTurn.g:3592:5: (lv_precondition_3_0= ruleCondition )
                            // InternalTurn.g:3593:6: lv_precondition_3_0= ruleCondition
                            {

                            						newCompositeNode(grammarAccess.getStartPointAccess().getPreconditionConditionParserRuleCall_0_2_0());
                            					
                            pushFollow(FOLLOW_2);
                            lv_precondition_3_0=ruleCondition();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getStartPointRule());
                            						}
                            						set(
                            							current,
                            							"precondition",
                            							lv_precondition_3_0,
                            							"org.jucmnav.turn.Turn.Condition");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:3612:3: ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? )
                    {
                    // InternalTurn.g:3612:3: ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? )
                    // InternalTurn.g:3613:4: ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )?
                    {
                    // InternalTurn.g:3613:4: ( (lv_failKind_4_0= ruleFailureKind ) )
                    // InternalTurn.g:3614:5: (lv_failKind_4_0= ruleFailureKind )
                    {
                    // InternalTurn.g:3614:5: (lv_failKind_4_0= ruleFailureKind )
                    // InternalTurn.g:3615:6: lv_failKind_4_0= ruleFailureKind
                    {

                    						newCompositeNode(grammarAccess.getStartPointAccess().getFailKindFailureKindEnumRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_failKind_4_0=ruleFailureKind();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStartPointRule());
                    						}
                    						set(
                    							current,
                    							"failKind",
                    							lv_failKind_4_0,
                    							"org.jucmnav.turn.Turn.FailureKind");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3632:4: ( (lv_name_5_0= ruleQualifiedName ) )
                    // InternalTurn.g:3633:5: (lv_name_5_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:3633:5: (lv_name_5_0= ruleQualifiedName )
                    // InternalTurn.g:3634:6: lv_name_5_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getStartPointAccess().getNameQualifiedNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_name_5_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStartPointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_5_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3651:4: ( (lv_longName_6_0= ruleLongName ) )
                    // InternalTurn.g:3652:5: (lv_longName_6_0= ruleLongName )
                    {
                    // InternalTurn.g:3652:5: (lv_longName_6_0= ruleLongName )
                    // InternalTurn.g:3653:6: lv_longName_6_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getStartPointAccess().getLongNameLongNameParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_68);
                    lv_longName_6_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStartPointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_6_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3670:4: (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==65) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalTurn.g:3671:5: otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]'
                            {
                            otherlv_7=(Token)match(input,65,FOLLOW_69); 

                            					newLeafNode(otherlv_7, grammarAccess.getStartPointAccess().getCatchesKeyword_1_3_0());
                            				
                            otherlv_8=(Token)match(input,66,FOLLOW_6); 

                            					newLeafNode(otherlv_8, grammarAccess.getStartPointAccess().getLeftSquareBracketLeftSquareBracketKeyword_1_3_1());
                            				
                            // InternalTurn.g:3679:5: ( (lv_catches_9_0= RULE_STRING ) )
                            // InternalTurn.g:3680:6: (lv_catches_9_0= RULE_STRING )
                            {
                            // InternalTurn.g:3680:6: (lv_catches_9_0= RULE_STRING )
                            // InternalTurn.g:3681:7: lv_catches_9_0= RULE_STRING
                            {
                            lv_catches_9_0=(Token)match(input,RULE_STRING,FOLLOW_70); 

                            							newLeafNode(lv_catches_9_0, grammarAccess.getStartPointAccess().getCatchesSTRINGTerminalRuleCall_1_3_2_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStartPointRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"catches",
                            								lv_catches_9_0,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }


                            }

                            otherlv_10=(Token)match(input,67,FOLLOW_2); 

                            					newLeafNode(otherlv_10, grammarAccess.getStartPointAccess().getRightSquareBracketRightSquareBracketKeyword_1_3_3());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartPoint"


    // $ANTLR start "entryRulePathBody"
    // InternalTurn.g:3707:1: entryRulePathBody returns [EObject current=null] : iv_rulePathBody= rulePathBody EOF ;
    public final EObject entryRulePathBody() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBody = null;


        try {
            // InternalTurn.g:3707:49: (iv_rulePathBody= rulePathBody EOF )
            // InternalTurn.g:3708:2: iv_rulePathBody= rulePathBody EOF
            {
             newCompositeNode(grammarAccess.getPathBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBody=rulePathBody();

            state._fsp--;

             current =iv_rulePathBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBody"


    // $ANTLR start "rulePathBody"
    // InternalTurn.g:3714:1: rulePathBody returns [EObject current=null] : this_PathWithRegularEnd_0= rulePathWithRegularEnd ;
    public final EObject rulePathBody() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithRegularEnd_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3720:2: (this_PathWithRegularEnd_0= rulePathWithRegularEnd )
            // InternalTurn.g:3721:2: this_PathWithRegularEnd_0= rulePathWithRegularEnd
            {

            		newCompositeNode(grammarAccess.getPathBodyAccess().getPathWithRegularEndParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_PathWithRegularEnd_0=rulePathWithRegularEnd();

            state._fsp--;


            		current = this_PathWithRegularEnd_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBody"


    // $ANTLR start "entryRulePathWithRegularEnd"
    // InternalTurn.g:3732:1: entryRulePathWithRegularEnd returns [EObject current=null] : iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF ;
    public final EObject entryRulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithRegularEnd = null;


        try {
            // InternalTurn.g:3732:59: (iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF )
            // InternalTurn.g:3733:2: iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF
            {
             newCompositeNode(grammarAccess.getPathWithRegularEndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithRegularEnd=rulePathWithRegularEnd();

            state._fsp--;

             current =iv_rulePathWithRegularEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithRegularEnd"


    // $ANTLR start "rulePathWithRegularEnd"
    // InternalTurn.g:3739:1: rulePathWithRegularEnd returns [EObject current=null] : (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) ;
    public final EObject rulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithReferencedEnd_0 = null;

        EObject lv_pathEnd_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3745:2: ( (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) )
            // InternalTurn.g:3746:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            {
            // InternalTurn.g:3746:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            // InternalTurn.g:3747:3: this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            {

            			newCompositeNode(grammarAccess.getPathWithRegularEndAccess().getPathWithReferencedEndParserRuleCall_0());
            		
            pushFollow(FOLLOW_71);
            this_PathWithReferencedEnd_0=rulePathWithReferencedEnd();

            state._fsp--;


            			current = this_PathWithReferencedEnd_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3755:3: ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=81 && LA70_0<=82)||(LA70_0>=84 && LA70_0<=85)||(LA70_0>=130 && LA70_0<=131)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalTurn.g:3756:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    {
                    // InternalTurn.g:3756:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    // InternalTurn.g:3757:5: lv_pathEnd_1_0= ruleRegularEnd
                    {

                    					newCompositeNode(grammarAccess.getPathWithRegularEndAccess().getPathEndRegularEndParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pathEnd_1_0=ruleRegularEnd();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPathWithRegularEndRule());
                    					}
                    					set(
                    						current,
                    						"pathEnd",
                    						lv_pathEnd_1_0,
                    						"org.jucmnav.turn.Turn.RegularEnd");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithRegularEnd"


    // $ANTLR start "entryRulePathWithReferencedEnd"
    // InternalTurn.g:3778:1: entryRulePathWithReferencedEnd returns [EObject current=null] : iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF ;
    public final EObject entryRulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedEnd = null;


        try {
            // InternalTurn.g:3778:62: (iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF )
            // InternalTurn.g:3779:2: iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF
            {
             newCompositeNode(grammarAccess.getPathWithReferencedEndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithReferencedEnd=rulePathWithReferencedEnd();

            state._fsp--;

             current =iv_rulePathWithReferencedEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithReferencedEnd"


    // $ANTLR start "rulePathWithReferencedEnd"
    // InternalTurn.g:3785:1: rulePathWithReferencedEnd returns [EObject current=null] : (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) ;
    public final EObject rulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_PathWithReferencedStub_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3791:2: ( (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) )
            // InternalTurn.g:3792:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            {
            // InternalTurn.g:3792:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            // InternalTurn.g:3793:3: this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedEndAccess().getPathWithReferencedStubParserRuleCall_0());
            		
            pushFollow(FOLLOW_72);
            this_PathWithReferencedStub_0=rulePathWithReferencedStub();

            state._fsp--;


            			current = this_PathWithReferencedStub_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3801:3: ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID) ) {
                int LA72_1 = input.LA(2);

                if ( (LA72_1==68) ) {
                    alt72=1;
                }
            }
            else if ( (LA72_0==68) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalTurn.g:3802:4: ( (otherlv_1= RULE_ID ) )? otherlv_2= ';'
                    {
                    // InternalTurn.g:3802:4: ( (otherlv_1= RULE_ID ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==RULE_ID) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalTurn.g:3803:5: (otherlv_1= RULE_ID )
                            {
                            // InternalTurn.g:3803:5: (otherlv_1= RULE_ID )
                            // InternalTurn.g:3804:6: otherlv_1= RULE_ID
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getPathWithReferencedEndRule());
                            						}
                            					
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_73); 

                            						newLeafNode(otherlv_1, grammarAccess.getPathWithReferencedEndAccess().getReferencedEndReferencedEndCrossReference_1_0_0());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,68,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPathWithReferencedEndAccess().getSemicolonKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithReferencedEnd"


    // $ANTLR start "entryRulePathWithReferencedStub"
    // InternalTurn.g:3824:1: entryRulePathWithReferencedStub returns [EObject current=null] : iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF ;
    public final EObject entryRulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedStub = null;


        try {
            // InternalTurn.g:3824:63: (iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF )
            // InternalTurn.g:3825:2: iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF
            {
             newCompositeNode(grammarAccess.getPathWithReferencedStubRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithReferencedStub=rulePathWithReferencedStub();

            state._fsp--;

             current =iv_rulePathWithReferencedStub; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithReferencedStub"


    // $ANTLR start "rulePathWithReferencedStub"
    // InternalTurn.g:3831:1: rulePathWithReferencedStub returns [EObject current=null] : (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) ;
    public final EObject rulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PathBodyNodes_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3837:2: ( (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) )
            // InternalTurn.g:3838:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            {
            // InternalTurn.g:3838:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            // InternalTurn.g:3839:3: this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getPathBodyNodesParserRuleCall_0());
            		
            pushFollow(FOLLOW_74);
            this_PathBodyNodes_0=rulePathBodyNodes();

            state._fsp--;


            			current = this_PathBodyNodes_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3847:3: (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==69) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalTurn.g:3848:4: otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';'
                    {
                    otherlv_1=(Token)match(input,69,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getPathWithReferencedStubAccess().getInKeyword_1_0());
                    			
                    // InternalTurn.g:3852:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:3853:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:3853:5: ( ruleQualifiedName )
                    // InternalTurn.g:3854:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPathWithReferencedStubRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getReferencedStubStubCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_54);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3868:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTurn.g:3869:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:3869:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTurn.g:3870:6: lv_index_3_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getIndexPositiveIntegerParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_73);
                    lv_index_3_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPathWithReferencedStubRule());
                    						}
                    						set(
                    							current,
                    							"index",
                    							lv_index_3_0,
                    							"org.jucmnav.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,68,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getPathWithReferencedStubAccess().getSemicolonKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithReferencedStub"


    // $ANTLR start "entryRulePathBodyNodes"
    // InternalTurn.g:3896:1: entryRulePathBodyNodes returns [EObject current=null] : iv_rulePathBodyNodes= rulePathBodyNodes EOF ;
    public final EObject entryRulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNodes = null;


        try {
            // InternalTurn.g:3896:54: (iv_rulePathBodyNodes= rulePathBodyNodes EOF )
            // InternalTurn.g:3897:2: iv_rulePathBodyNodes= rulePathBodyNodes EOF
            {
             newCompositeNode(grammarAccess.getPathBodyNodesRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBodyNodes=rulePathBodyNodes();

            state._fsp--;

             current =iv_rulePathBodyNodes; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBodyNodes"


    // $ANTLR start "rulePathBodyNodes"
    // InternalTurn.g:3903:1: rulePathBodyNodes returns [EObject current=null] : ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) ;
    public final EObject rulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_pathNodes_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3909:2: ( ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) )
            // InternalTurn.g:3910:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            {
            // InternalTurn.g:3910:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            // InternalTurn.g:3911:3: () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            {
            // InternalTurn.g:3911:3: ()
            // InternalTurn.g:3912:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPathBodyNodesAccess().getPathBodyNodesAction_0(),
            					current);
            			

            }


            			newCompositeNode(grammarAccess.getPathBodyNodesAccess().getArrowParserRuleCall_1());
            		
            pushFollow(FOLLOW_75);
            ruleArrow();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3925:3: ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=71 && LA74_0<=77)||(LA74_0>=79 && LA74_0<=80)||(LA74_0>=121 && LA74_0<=122)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalTurn.g:3926:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->'
            	    {
            	    // InternalTurn.g:3926:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) )
            	    // InternalTurn.g:3927:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    {
            	    // InternalTurn.g:3927:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    // InternalTurn.g:3928:6: lv_pathNodes_2_0= rulePathBodyNode
            	    {

            	    						newCompositeNode(grammarAccess.getPathBodyNodesAccess().getPathNodesPathBodyNodeParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_63);
            	    lv_pathNodes_2_0=rulePathBodyNode();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPathBodyNodesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pathNodes",
            	    							lv_pathNodes_2_0,
            	    							"org.jucmnav.turn.Turn.PathBodyNode");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,70,FOLLOW_75); 

            	    				newLeafNode(otherlv_3, grammarAccess.getPathBodyNodesAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBodyNodes"


    // $ANTLR start "entryRuleArrow"
    // InternalTurn.g:3954:1: entryRuleArrow returns [String current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final String entryRuleArrow() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrow = null;


        try {
            // InternalTurn.g:3954:45: (iv_ruleArrow= ruleArrow EOF )
            // InternalTurn.g:3955:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // InternalTurn.g:3961:1: ruleArrow returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '->' ;
    public final AntlrDatatypeRuleToken ruleArrow() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTurn.g:3967:2: (kw= '->' )
            // InternalTurn.g:3968:2: kw= '->'
            {
            kw=(Token)match(input,70,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRulePathBodyNode"
    // InternalTurn.g:3976:1: entryRulePathBodyNode returns [EObject current=null] : iv_rulePathBodyNode= rulePathBodyNode EOF ;
    public final EObject entryRulePathBodyNode() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNode = null;


        try {
            // InternalTurn.g:3976:53: (iv_rulePathBodyNode= rulePathBodyNode EOF )
            // InternalTurn.g:3977:2: iv_rulePathBodyNode= rulePathBodyNode EOF
            {
             newCompositeNode(grammarAccess.getPathBodyNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBodyNode=rulePathBodyNode();

            state._fsp--;

             current =iv_rulePathBodyNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBodyNode"


    // $ANTLR start "rulePathBodyNode"
    // InternalTurn.g:3983:1: rulePathBodyNode returns [EObject current=null] : (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) ;
    public final EObject rulePathBodyNode() throws RecognitionException {
        EObject current = null;

        EObject this_AndJoin_0 = null;

        EObject this_RespRef_1 = null;

        EObject this_OrJoin_2 = null;

        EObject this_WaitingPlace_3 = null;

        EObject this_FailurePoint_4 = null;

        EObject this_Timer_5 = null;

        EObject this_Connect_6 = null;



        	enterRule();

        try {
            // InternalTurn.g:3989:2: ( (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) )
            // InternalTurn.g:3990:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            {
            // InternalTurn.g:3990:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            int alt75=7;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalTurn.g:3991:3: this_AndJoin_0= ruleAndJoin
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getAndJoinParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AndJoin_0=ruleAndJoin();

                    state._fsp--;


                    			current = this_AndJoin_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:4000:3: this_RespRef_1= ruleRespRef
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getRespRefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RespRef_1=ruleRespRef();

                    state._fsp--;


                    			current = this_RespRef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:4009:3: this_OrJoin_2= ruleOrJoin
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getOrJoinParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrJoin_2=ruleOrJoin();

                    state._fsp--;


                    			current = this_OrJoin_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTurn.g:4018:3: this_WaitingPlace_3= ruleWaitingPlace
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getWaitingPlaceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_WaitingPlace_3=ruleWaitingPlace();

                    state._fsp--;


                    			current = this_WaitingPlace_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalTurn.g:4027:3: this_FailurePoint_4= ruleFailurePoint
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getFailurePointParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FailurePoint_4=ruleFailurePoint();

                    state._fsp--;


                    			current = this_FailurePoint_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalTurn.g:4036:3: this_Timer_5= ruleTimer
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getTimerParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Timer_5=ruleTimer();

                    state._fsp--;


                    			current = this_Timer_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalTurn.g:4045:3: this_Connect_6= ruleConnect
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getConnectParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Connect_6=ruleConnect();

                    state._fsp--;


                    			current = this_Connect_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBodyNode"


    // $ANTLR start "entryRuleRegularEnd"
    // InternalTurn.g:4057:1: entryRuleRegularEnd returns [EObject current=null] : iv_ruleRegularEnd= ruleRegularEnd EOF ;
    public final EObject entryRuleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEnd = null;


        try {
            // InternalTurn.g:4057:51: (iv_ruleRegularEnd= ruleRegularEnd EOF )
            // InternalTurn.g:4058:2: iv_ruleRegularEnd= ruleRegularEnd EOF
            {
             newCompositeNode(grammarAccess.getRegularEndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularEnd=ruleRegularEnd();

            state._fsp--;

             current =iv_ruleRegularEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularEnd"


    // $ANTLR start "ruleRegularEnd"
    // InternalTurn.g:4064:1: ruleRegularEnd returns [EObject current=null] : (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) ;
    public final EObject ruleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_EndpointWithConnect_0 = null;

        EObject this_AndFork_1 = null;

        EObject this_OrFork_2 = null;

        EObject this_Stub_3 = null;



        	enterRule();

        try {
            // InternalTurn.g:4070:2: ( (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) )
            // InternalTurn.g:4071:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            {
            // InternalTurn.g:4071:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            int alt76=4;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt76=1;
                }
                break;
            case 84:
                {
                alt76=2;
                }
                break;
            case 82:
                {
                alt76=3;
                }
                break;
            case 85:
            case 130:
            case 131:
                {
                alt76=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // InternalTurn.g:4072:3: this_EndpointWithConnect_0= ruleEndpointWithConnect
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getEndpointWithConnectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EndpointWithConnect_0=ruleEndpointWithConnect();

                    state._fsp--;


                    			current = this_EndpointWithConnect_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:4081:3: this_AndFork_1= ruleAndFork
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getAndForkParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AndFork_1=ruleAndFork();

                    state._fsp--;


                    			current = this_AndFork_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:4090:3: this_OrFork_2= ruleOrFork
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getOrForkParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrFork_2=ruleOrFork();

                    state._fsp--;


                    			current = this_OrFork_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTurn.g:4099:3: this_Stub_3= ruleStub
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getStubParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Stub_3=ruleStub();

                    state._fsp--;


                    			current = this_Stub_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularEnd"


    // $ANTLR start "entryRuleEndpointWithConnect"
    // InternalTurn.g:4111:1: entryRuleEndpointWithConnect returns [EObject current=null] : iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF ;
    public final EObject entryRuleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpointWithConnect = null;


        try {
            // InternalTurn.g:4111:60: (iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF )
            // InternalTurn.g:4112:2: iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF
            {
             newCompositeNode(grammarAccess.getEndpointWithConnectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndpointWithConnect=ruleEndpointWithConnect();

            state._fsp--;

             current =iv_ruleEndpointWithConnect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndpointWithConnect"


    // $ANTLR start "ruleEndpointWithConnect"
    // InternalTurn.g:4118:1: ruleEndpointWithConnect returns [EObject current=null] : ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) ;
    public final EObject ruleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_regularEnd_0_0 = null;

        EObject lv_connect_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4124:2: ( ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) )
            // InternalTurn.g:4125:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            {
            // InternalTurn.g:4125:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            // InternalTurn.g:4126:3: ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            {
            // InternalTurn.g:4126:3: ( (lv_regularEnd_0_0= ruleEndPoint ) )
            // InternalTurn.g:4127:4: (lv_regularEnd_0_0= ruleEndPoint )
            {
            // InternalTurn.g:4127:4: (lv_regularEnd_0_0= ruleEndPoint )
            // InternalTurn.g:4128:5: lv_regularEnd_0_0= ruleEndPoint
            {

            					newCompositeNode(grammarAccess.getEndpointWithConnectAccess().getRegularEndEndPointParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_76);
            lv_regularEnd_0_0=ruleEndPoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEndpointWithConnectRule());
            					}
            					set(
            						current,
            						"regularEnd",
            						lv_regularEnd_0_0,
            						"org.jucmnav.turn.Turn.EndPoint");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4145:3: (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==70) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalTurn.g:4146:4: otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) )
                    {
                    otherlv_1=(Token)match(input,70,FOLLOW_77); 

                    				newLeafNode(otherlv_1, grammarAccess.getEndpointWithConnectAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                    			
                    // InternalTurn.g:4150:4: ( (lv_connect_2_0= ruleConnect ) )
                    // InternalTurn.g:4151:5: (lv_connect_2_0= ruleConnect )
                    {
                    // InternalTurn.g:4151:5: (lv_connect_2_0= ruleConnect )
                    // InternalTurn.g:4152:6: lv_connect_2_0= ruleConnect
                    {

                    						newCompositeNode(grammarAccess.getEndpointWithConnectAccess().getConnectConnectParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_connect_2_0=ruleConnect();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndpointWithConnectRule());
                    						}
                    						set(
                    							current,
                    							"connect",
                    							lv_connect_2_0,
                    							"org.jucmnav.turn.Turn.Connect");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndpointWithConnect"


    // $ANTLR start "entryRuleRespRef"
    // InternalTurn.g:4174:1: entryRuleRespRef returns [EObject current=null] : iv_ruleRespRef= ruleRespRef EOF ;
    public final EObject entryRuleRespRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRespRef = null;


        try {
            // InternalTurn.g:4174:48: (iv_ruleRespRef= ruleRespRef EOF )
            // InternalTurn.g:4175:2: iv_ruleRespRef= ruleRespRef EOF
            {
             newCompositeNode(grammarAccess.getRespRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRespRef=ruleRespRef();

            state._fsp--;

             current =iv_ruleRespRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRespRef"


    // $ANTLR start "ruleRespRef"
    // InternalTurn.g:4181:1: ruleRespRef returns [EObject current=null] : (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) ;
    public final EObject ruleRespRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4187:2: ( (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) )
            // InternalTurn.g:4188:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4188:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            // InternalTurn.g:4189:3: otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRespRefAccess().getXKeyword_0());
            		
            // InternalTurn.g:4193:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:4194:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:4194:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:4195:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getRespRefAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_78);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRespRefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4212:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:4213:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:4213:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:4214:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getRespRefAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRespRefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRespRef"


    // $ANTLR start "entryRuleOrJoin"
    // InternalTurn.g:4235:1: entryRuleOrJoin returns [EObject current=null] : iv_ruleOrJoin= ruleOrJoin EOF ;
    public final EObject entryRuleOrJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrJoin = null;


        try {
            // InternalTurn.g:4235:47: (iv_ruleOrJoin= ruleOrJoin EOF )
            // InternalTurn.g:4236:2: iv_ruleOrJoin= ruleOrJoin EOF
            {
             newCompositeNode(grammarAccess.getOrJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrJoin=ruleOrJoin();

            state._fsp--;

             current =iv_ruleOrJoin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrJoin"


    // $ANTLR start "ruleOrJoin"
    // InternalTurn.g:4242:1: ruleOrJoin returns [EObject current=null] : ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) ;
    public final EObject ruleOrJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4248:2: ( ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) )
            // InternalTurn.g:4249:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4249:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            // InternalTurn.g:4250:3: () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
            {
            // InternalTurn.g:4250:3: ()
            // InternalTurn.g:4251:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOrJoinAccess().getOrJoinAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,72,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOrJoinAccess().getJoinKeyword_1());
            		
            // InternalTurn.g:4261:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:4262:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:4262:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:4263:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getOrJoinAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_78);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4280:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:4281:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:4281:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:4282:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getOrJoinAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrJoinRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrJoin"


    // $ANTLR start "entryRuleAndJoin"
    // InternalTurn.g:4303:1: entryRuleAndJoin returns [EObject current=null] : iv_ruleAndJoin= ruleAndJoin EOF ;
    public final EObject entryRuleAndJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndJoin = null;


        try {
            // InternalTurn.g:4303:48: (iv_ruleAndJoin= ruleAndJoin EOF )
            // InternalTurn.g:4304:2: iv_ruleAndJoin= ruleAndJoin EOF
            {
             newCompositeNode(grammarAccess.getAndJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndJoin=ruleAndJoin();

            state._fsp--;

             current =iv_ruleAndJoin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndJoin"


    // $ANTLR start "ruleAndJoin"
    // InternalTurn.g:4310:1: ruleAndJoin returns [EObject current=null] : ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) ;
    public final EObject ruleAndJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_longName_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4316:2: ( ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) )
            // InternalTurn.g:4317:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4317:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            // InternalTurn.g:4318:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) )
            {
            // InternalTurn.g:4318:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' )
            int alt78=3;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt78=1;
                }
                break;
            case 74:
                {
                alt78=2;
                }
                break;
            case 75:
                {
                alt78=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalTurn.g:4319:4: otherlv_0= 'synch'
                    {
                    otherlv_0=(Token)match(input,73,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getAndJoinAccess().getSynchKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTurn.g:4324:4: otherlv_1= 'sync'
                    {
                    otherlv_1=(Token)match(input,74,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getAndJoinAccess().getSyncKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalTurn.g:4329:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,75,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getAndJoinAccess().getVerticalLineKeyword_0_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:4334:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalTurn.g:4335:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalTurn.g:4335:4: (lv_name_3_0= ruleQualifiedName )
            // InternalTurn.g:4336:5: lv_name_3_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getAndJoinAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_78);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4353:3: ( (lv_longName_4_0= ruleLongName ) )
            // InternalTurn.g:4354:4: (lv_longName_4_0= ruleLongName )
            {
            // InternalTurn.g:4354:4: (lv_longName_4_0= ruleLongName )
            // InternalTurn.g:4355:5: lv_longName_4_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getAndJoinAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_4_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndJoinRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_4_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndJoin"


    // $ANTLR start "entryRuleWaitingPlace"
    // InternalTurn.g:4376:1: entryRuleWaitingPlace returns [EObject current=null] : iv_ruleWaitingPlace= ruleWaitingPlace EOF ;
    public final EObject entryRuleWaitingPlace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWaitingPlace = null;


        try {
            // InternalTurn.g:4376:53: (iv_ruleWaitingPlace= ruleWaitingPlace EOF )
            // InternalTurn.g:4377:2: iv_ruleWaitingPlace= ruleWaitingPlace EOF
            {
             newCompositeNode(grammarAccess.getWaitingPlaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWaitingPlace=ruleWaitingPlace();

            state._fsp--;

             current =iv_ruleWaitingPlace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWaitingPlace"


    // $ANTLR start "ruleWaitingPlace"
    // InternalTurn.g:4383:1: ruleWaitingPlace returns [EObject current=null] : ( ( (lv_kind_0_0= ruleWaitKind ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) ;
    public final EObject ruleWaitingPlace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_kind_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4389:2: ( ( ( (lv_kind_0_0= ruleWaitKind ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) )
            // InternalTurn.g:4390:2: ( ( (lv_kind_0_0= ruleWaitKind ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            {
            // InternalTurn.g:4390:2: ( ( (lv_kind_0_0= ruleWaitKind ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            // InternalTurn.g:4391:3: ( (lv_kind_0_0= ruleWaitKind ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )?
            {
            // InternalTurn.g:4391:3: ( (lv_kind_0_0= ruleWaitKind ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=121 && LA79_0<=122)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalTurn.g:4392:4: (lv_kind_0_0= ruleWaitKind )
                    {
                    // InternalTurn.g:4392:4: (lv_kind_0_0= ruleWaitKind )
                    // InternalTurn.g:4393:5: lv_kind_0_0= ruleWaitKind
                    {

                    					newCompositeNode(grammarAccess.getWaitingPlaceAccess().getKindWaitKindEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_79);
                    lv_kind_0_0=ruleWaitKind();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_0_0,
                    						"org.jucmnav.turn.Turn.WaitKind");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,76,FOLLOW_64); 

            			newLeafNode(otherlv_1, grammarAccess.getWaitingPlaceAccess().getWaitKeyword_1());
            		
            // InternalTurn.g:4414:3: ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalTurn.g:4415:4: ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4415:4: ( (lv_name_2_0= ruleQualifiedName ) )
                    // InternalTurn.g:4416:5: (lv_name_2_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4416:5: (lv_name_2_0= ruleQualifiedName )
                    // InternalTurn.g:4417:6: lv_name_2_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getWaitingPlaceAccess().getNameQualifiedNameParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_65);
                    lv_name_2_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4434:4: ( (lv_longName_3_0= ruleLongName ) )
                    // InternalTurn.g:4435:5: (lv_longName_3_0= ruleLongName )
                    {
                    // InternalTurn.g:4435:5: (lv_longName_3_0= ruleLongName )
                    // InternalTurn.g:4436:6: lv_longName_3_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getWaitingPlaceAccess().getLongNameLongNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_66);
                    lv_longName_3_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_3_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4454:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==24) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalTurn.g:4455:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTurn.g:4455:4: (lv_condition_4_0= ruleCondition )
                    // InternalTurn.g:4456:5: lv_condition_4_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getWaitingPlaceAccess().getConditionConditionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_condition_4_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_4_0,
                    						"org.jucmnav.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWaitingPlace"


    // $ANTLR start "entryRuleTimer"
    // InternalTurn.g:4477:1: entryRuleTimer returns [EObject current=null] : iv_ruleTimer= ruleTimer EOF ;
    public final EObject entryRuleTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimer = null;


        try {
            // InternalTurn.g:4477:46: (iv_ruleTimer= ruleTimer EOF )
            // InternalTurn.g:4478:2: iv_ruleTimer= ruleTimer EOF
            {
             newCompositeNode(grammarAccess.getTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimer=ruleTimer();

            state._fsp--;

             current =iv_ruleTimer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimer"


    // $ANTLR start "ruleTimer"
    // InternalTurn.g:4484:1: ruleTimer returns [EObject current=null] : ( () ( (lv_kind_1_0= ruleWaitKind ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? ) ;
    public final EObject ruleTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Enumerator lv_kind_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_longName_4_0 = null;

        EObject lv_timeoutCondition_7_0 = null;

        EObject lv_timeoutPath_8_0 = null;

        EObject lv_condition_10_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4490:2: ( ( () ( (lv_kind_1_0= ruleWaitKind ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? ) )
            // InternalTurn.g:4491:2: ( () ( (lv_kind_1_0= ruleWaitKind ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? )
            {
            // InternalTurn.g:4491:2: ( () ( (lv_kind_1_0= ruleWaitKind ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? )
            // InternalTurn.g:4492:3: () ( (lv_kind_1_0= ruleWaitKind ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )?
            {
            // InternalTurn.g:4492:3: ()
            // InternalTurn.g:4493:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimerAccess().getTimerAction_0(),
            					current);
            			

            }

            // InternalTurn.g:4499:3: ( (lv_kind_1_0= ruleWaitKind ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=121 && LA82_0<=122)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalTurn.g:4500:4: (lv_kind_1_0= ruleWaitKind )
                    {
                    // InternalTurn.g:4500:4: (lv_kind_1_0= ruleWaitKind )
                    // InternalTurn.g:4501:5: lv_kind_1_0= ruleWaitKind
                    {

                    					newCompositeNode(grammarAccess.getTimerAccess().getKindWaitKindEnumRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_80);
                    lv_kind_1_0=ruleWaitKind();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimerRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_1_0,
                    						"org.jucmnav.turn.Turn.WaitKind");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,77,FOLLOW_81); 

            			newLeafNode(otherlv_2, grammarAccess.getTimerAccess().getTimerKeyword_2());
            		
            // InternalTurn.g:4522:3: ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_ID) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalTurn.g:4523:4: ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4523:4: ( (lv_name_3_0= ruleQualifiedName ) )
                    // InternalTurn.g:4524:5: (lv_name_3_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4524:5: (lv_name_3_0= ruleQualifiedName )
                    // InternalTurn.g:4525:6: lv_name_3_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getTimerAccess().getNameQualifiedNameParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_82);
                    lv_name_3_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimerRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4542:4: ( (lv_longName_4_0= ruleLongName ) )
                    // InternalTurn.g:4543:5: (lv_longName_4_0= ruleLongName )
                    {
                    // InternalTurn.g:4543:5: (lv_longName_4_0= ruleLongName )
                    // InternalTurn.g:4544:6: lv_longName_4_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getTimerAccess().getLongNameLongNameParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_83);
                    lv_longName_4_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimerRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_4_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4562:3: (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==13) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalTurn.g:4563:4: otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_84); 

                    				newLeafNode(otherlv_5, grammarAccess.getTimerAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalTurn.g:4567:4: (otherlv_6= 'timeout' )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==78) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalTurn.g:4568:5: otherlv_6= 'timeout'
                            {
                            otherlv_6=(Token)match(input,78,FOLLOW_85); 

                            					newLeafNode(otherlv_6, grammarAccess.getTimerAccess().getTimeoutKeyword_4_1());
                            				

                            }
                            break;

                    }

                    // InternalTurn.g:4573:4: ( (lv_timeoutCondition_7_0= ruleCondition ) )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==24) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalTurn.g:4574:5: (lv_timeoutCondition_7_0= ruleCondition )
                            {
                            // InternalTurn.g:4574:5: (lv_timeoutCondition_7_0= ruleCondition )
                            // InternalTurn.g:4575:6: lv_timeoutCondition_7_0= ruleCondition
                            {

                            						newCompositeNode(grammarAccess.getTimerAccess().getTimeoutConditionConditionParserRuleCall_4_2_0());
                            					
                            pushFollow(FOLLOW_86);
                            lv_timeoutCondition_7_0=ruleCondition();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getTimerRule());
                            						}
                            						set(
                            							current,
                            							"timeoutCondition",
                            							lv_timeoutCondition_7_0,
                            							"org.jucmnav.turn.Turn.Condition");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalTurn.g:4592:4: ( (lv_timeoutPath_8_0= rulePathBody ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==70) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalTurn.g:4593:5: (lv_timeoutPath_8_0= rulePathBody )
                            {
                            // InternalTurn.g:4593:5: (lv_timeoutPath_8_0= rulePathBody )
                            // InternalTurn.g:4594:6: lv_timeoutPath_8_0= rulePathBody
                            {

                            						newCompositeNode(grammarAccess.getTimerAccess().getTimeoutPathPathBodyParserRuleCall_4_3_0());
                            					
                            pushFollow(FOLLOW_12);
                            lv_timeoutPath_8_0=rulePathBody();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getTimerRule());
                            						}
                            						set(
                            							current,
                            							"timeoutPath",
                            							lv_timeoutPath_8_0,
                            							"org.jucmnav.turn.Turn.PathBody");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_66); 

                    				newLeafNode(otherlv_9, grammarAccess.getTimerAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalTurn.g:4616:3: ( (lv_condition_10_0= ruleCondition ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==24) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalTurn.g:4617:4: (lv_condition_10_0= ruleCondition )
                    {
                    // InternalTurn.g:4617:4: (lv_condition_10_0= ruleCondition )
                    // InternalTurn.g:4618:5: lv_condition_10_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getTimerAccess().getConditionConditionParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_condition_10_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimerRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_10_0,
                    						"org.jucmnav.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimer"


    // $ANTLR start "entryRuleConnect"
    // InternalTurn.g:4639:1: entryRuleConnect returns [EObject current=null] : iv_ruleConnect= ruleConnect EOF ;
    public final EObject entryRuleConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnect = null;


        try {
            // InternalTurn.g:4639:48: (iv_ruleConnect= ruleConnect EOF )
            // InternalTurn.g:4640:2: iv_ruleConnect= ruleConnect EOF
            {
             newCompositeNode(grammarAccess.getConnectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnect=ruleConnect();

            state._fsp--;

             current =iv_ruleConnect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnect"


    // $ANTLR start "ruleConnect"
    // InternalTurn.g:4646:1: ruleConnect returns [EObject current=null] : (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTurn.g:4652:2: ( (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalTurn.g:4653:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalTurn.g:4653:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalTurn.g:4654:3: otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConnectAccess().getTriggerKeyword_0());
            		
            // InternalTurn.g:4658:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:4659:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:4659:4: ( ruleQualifiedName )
            // InternalTurn.g:4660:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConnectAccess().getConnectsToConnectElementCrossReference_1_0());
            				
            pushFollow(FOLLOW_73);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getConnectAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnect"


    // $ANTLR start "entryRuleFailurePoint"
    // InternalTurn.g:4682:1: entryRuleFailurePoint returns [EObject current=null] : iv_ruleFailurePoint= ruleFailurePoint EOF ;
    public final EObject entryRuleFailurePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailurePoint = null;


        try {
            // InternalTurn.g:4682:53: (iv_ruleFailurePoint= ruleFailurePoint EOF )
            // InternalTurn.g:4683:2: iv_ruleFailurePoint= ruleFailurePoint EOF
            {
             newCompositeNode(grammarAccess.getFailurePointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailurePoint=ruleFailurePoint();

            state._fsp--;

             current =iv_ruleFailurePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailurePoint"


    // $ANTLR start "ruleFailurePoint"
    // InternalTurn.g:4689:1: ruleFailurePoint returns [EObject current=null] : (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) ;
    public final EObject ruleFailurePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_3_0 = null;

        EObject lv_failLabel_4_0 = null;

        EObject lv_failLabel_5_0 = null;

        EObject lv_condition_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4695:2: ( (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) )
            // InternalTurn.g:4696:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            {
            // InternalTurn.g:4696:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            // InternalTurn.g:4697:3: otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            {
            otherlv_0=(Token)match(input,80,FOLLOW_87); 

            			newLeafNode(otherlv_0, grammarAccess.getFailurePointAccess().getFailKeyword_0());
            		
            // InternalTurn.g:4701:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_ID) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalTurn.g:4702:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4702:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:4703:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4703:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:4704:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getFailurePointAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_88);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4721:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:4722:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:4722:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:4723:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getFailurePointAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_89);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4741:3: ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            int alt90=3;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==24) ) {
                alt90=1;
            }
            else if ( (LA90_0==66) ) {
                alt90=2;
            }
            switch (alt90) {
                case 1 :
                    // InternalTurn.g:4742:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    {
                    // InternalTurn.g:4742:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    // InternalTurn.g:4743:5: ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    {
                    // InternalTurn.g:4743:5: ( (lv_condition_3_0= ruleCondition ) )
                    // InternalTurn.g:4744:6: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTurn.g:4744:6: (lv_condition_3_0= ruleCondition )
                    // InternalTurn.g:4745:7: lv_condition_3_0= ruleCondition
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getConditionConditionParserRuleCall_2_0_0_0());
                    						
                    pushFollow(FOLLOW_69);
                    lv_condition_3_0=ruleCondition();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"condition",
                    								lv_condition_3_0,
                    								"org.jucmnav.turn.Turn.Condition");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTurn.g:4762:5: ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    // InternalTurn.g:4763:6: (lv_failLabel_4_0= ruleFailureLabel )
                    {
                    // InternalTurn.g:4763:6: (lv_failLabel_4_0= ruleFailureLabel )
                    // InternalTurn.g:4764:7: lv_failLabel_4_0= ruleFailureLabel
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getFailLabelFailureLabelParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_failLabel_4_0=ruleFailureLabel();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"failLabel",
                    								lv_failLabel_4_0,
                    								"org.jucmnav.turn.Turn.FailureLabel");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:4783:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    {
                    // InternalTurn.g:4783:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    // InternalTurn.g:4784:5: ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTurn.g:4784:5: ( (lv_failLabel_5_0= ruleFailureLabel ) )
                    // InternalTurn.g:4785:6: (lv_failLabel_5_0= ruleFailureLabel )
                    {
                    // InternalTurn.g:4785:6: (lv_failLabel_5_0= ruleFailureLabel )
                    // InternalTurn.g:4786:7: lv_failLabel_5_0= ruleFailureLabel
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getFailLabelFailureLabelParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FOLLOW_90);
                    lv_failLabel_5_0=ruleFailureLabel();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"failLabel",
                    								lv_failLabel_5_0,
                    								"org.jucmnav.turn.Turn.FailureLabel");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTurn.g:4803:5: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTurn.g:4804:6: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTurn.g:4804:6: (lv_condition_6_0= ruleCondition )
                    // InternalTurn.g:4805:7: lv_condition_6_0= ruleCondition
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getConditionConditionParserRuleCall_2_1_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_condition_6_0=ruleCondition();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"condition",
                    								lv_condition_6_0,
                    								"org.jucmnav.turn.Turn.Condition");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailurePoint"


    // $ANTLR start "entryRuleEndPoint"
    // InternalTurn.g:4828:1: entryRuleEndPoint returns [EObject current=null] : iv_ruleEndPoint= ruleEndPoint EOF ;
    public final EObject entryRuleEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndPoint = null;


        try {
            // InternalTurn.g:4828:49: (iv_ruleEndPoint= ruleEndPoint EOF )
            // InternalTurn.g:4829:2: iv_ruleEndPoint= ruleEndPoint EOF
            {
             newCompositeNode(grammarAccess.getEndPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndPoint=ruleEndPoint();

            state._fsp--;

             current =iv_ruleEndPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndPoint"


    // $ANTLR start "ruleEndPoint"
    // InternalTurn.g:4835:1: ruleEndPoint returns [EObject current=null] : (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) ;
    public final EObject ruleEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4841:2: ( (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) )
            // InternalTurn.g:4842:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            {
            // InternalTurn.g:4842:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            // InternalTurn.g:4843:3: otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_91); 

            			newLeafNode(otherlv_0, grammarAccess.getEndPointAccess().getEndKeyword_0());
            		
            // InternalTurn.g:4847:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalTurn.g:4848:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4848:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:4849:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4849:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:4850:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getEndPointAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_92);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndPointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4867:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:4868:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:4868:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:4869:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getEndPointAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_93);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndPointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4887:3: ( (lv_condition_3_0= ruleCondition ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==24) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalTurn.g:4888:4: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTurn.g:4888:4: (lv_condition_3_0= ruleCondition )
                    // InternalTurn.g:4889:5: lv_condition_3_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getEndPointAccess().getConditionConditionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_94);
                    lv_condition_3_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEndPointRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_3_0,
                    						"org.jucmnav.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEndPointAccess().getFullStopKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndPoint"


    // $ANTLR start "entryRuleOrFork"
    // InternalTurn.g:4914:1: entryRuleOrFork returns [EObject current=null] : iv_ruleOrFork= ruleOrFork EOF ;
    public final EObject entryRuleOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrFork = null;


        try {
            // InternalTurn.g:4914:47: (iv_ruleOrFork= ruleOrFork EOF )
            // InternalTurn.g:4915:2: iv_ruleOrFork= ruleOrFork EOF
            {
             newCompositeNode(grammarAccess.getOrForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrFork=ruleOrFork();

            state._fsp--;

             current =iv_ruleOrFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrFork"


    // $ANTLR start "ruleOrFork"
    // InternalTurn.g:4921:1: ruleOrFork returns [EObject current=null] : (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? ) ;
    public final EObject ruleOrFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_body_4_0 = null;

        EObject lv_condition_6_0 = null;

        EObject lv_connectingOrBody_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4927:2: ( (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? ) )
            // InternalTurn.g:4928:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? )
            {
            // InternalTurn.g:4928:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? )
            // InternalTurn.g:4929:3: otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )?
            {
            otherlv_0=(Token)match(input,82,FOLLOW_95); 

            			newLeafNode(otherlv_0, grammarAccess.getOrForkAccess().getOrKeyword_0());
            		
            // InternalTurn.g:4933:3: ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_ID||LA94_0==13) ) {
                alt94=1;
            }
            else if ( (LA94_0==24) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalTurn.g:4934:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    {
                    // InternalTurn.g:4934:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    // InternalTurn.g:4935:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}'
                    {
                    // InternalTurn.g:4935:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==RULE_ID) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalTurn.g:4936:6: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                            {
                            // InternalTurn.g:4936:6: ( (lv_name_1_0= ruleQualifiedName ) )
                            // InternalTurn.g:4937:7: (lv_name_1_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:4937:7: (lv_name_1_0= ruleQualifiedName )
                            // InternalTurn.g:4938:8: lv_name_1_0= ruleQualifiedName
                            {

                            								newCompositeNode(grammarAccess.getOrForkAccess().getNameQualifiedNameParserRuleCall_1_0_0_0_0());
                            							
                            pushFollow(FOLLOW_27);
                            lv_name_1_0=ruleQualifiedName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getOrForkRule());
                            								}
                            								set(
                            									current,
                            									"name",
                            									lv_name_1_0,
                            									"org.jucmnav.turn.Turn.QualifiedName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalTurn.g:4955:6: ( (lv_longName_2_0= ruleLongName ) )
                            // InternalTurn.g:4956:7: (lv_longName_2_0= ruleLongName )
                            {
                            // InternalTurn.g:4956:7: (lv_longName_2_0= ruleLongName )
                            // InternalTurn.g:4957:8: lv_longName_2_0= ruleLongName
                            {

                            								newCompositeNode(grammarAccess.getOrForkAccess().getLongNameLongNameParserRuleCall_1_0_0_1_0());
                            							
                            pushFollow(FOLLOW_28);
                            lv_longName_2_0=ruleLongName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getOrForkRule());
                            								}
                            								set(
                            									current,
                            									"longName",
                            									lv_longName_2_0,
                            									"org.jucmnav.turn.Turn.LongName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_90); 

                    					newLeafNode(otherlv_3, grammarAccess.getOrForkAccess().getLeftCurlyBracketKeyword_1_0_1());
                    				
                    // InternalTurn.g:4979:5: ( (lv_body_4_0= ruleOrBody ) )
                    // InternalTurn.g:4980:6: (lv_body_4_0= ruleOrBody )
                    {
                    // InternalTurn.g:4980:6: (lv_body_4_0= ruleOrBody )
                    // InternalTurn.g:4981:7: lv_body_4_0= ruleOrBody
                    {

                    							newCompositeNode(grammarAccess.getOrForkAccess().getBodyOrBodyParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_12);
                    lv_body_4_0=ruleOrBody();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOrForkRule());
                    							}
                    							set(
                    								current,
                    								"body",
                    								lv_body_4_0,
                    								"org.jucmnav.turn.Turn.OrBody");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_76); 

                    					newLeafNode(otherlv_5, grammarAccess.getOrForkAccess().getRightCurlyBracketKeyword_1_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:5004:4: ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTurn.g:5004:4: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTurn.g:5005:5: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTurn.g:5005:5: (lv_condition_6_0= ruleCondition )
                    // InternalTurn.g:5006:6: lv_condition_6_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getOrForkAccess().getConditionConditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_76);
                    lv_condition_6_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOrForkRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_6_0,
                    							"org.jucmnav.turn.Turn.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:5024:3: ( (lv_connectingOrBody_7_0= rulePathBody ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==70) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalTurn.g:5025:4: (lv_connectingOrBody_7_0= rulePathBody )
                    {
                    // InternalTurn.g:5025:4: (lv_connectingOrBody_7_0= rulePathBody )
                    // InternalTurn.g:5026:5: lv_connectingOrBody_7_0= rulePathBody
                    {

                    					newCompositeNode(grammarAccess.getOrForkAccess().getConnectingOrBodyPathBodyParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_connectingOrBody_7_0=rulePathBody();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOrForkRule());
                    					}
                    					set(
                    						current,
                    						"connectingOrBody",
                    						lv_connectingOrBody_7_0,
                    						"org.jucmnav.turn.Turn.PathBody");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrFork"


    // $ANTLR start "entryRuleOrBody"
    // InternalTurn.g:5047:1: entryRuleOrBody returns [EObject current=null] : iv_ruleOrBody= ruleOrBody EOF ;
    public final EObject entryRuleOrBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBody = null;


        try {
            // InternalTurn.g:5047:47: (iv_ruleOrBody= ruleOrBody EOF )
            // InternalTurn.g:5048:2: iv_ruleOrBody= ruleOrBody EOF
            {
             newCompositeNode(grammarAccess.getOrBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrBody=ruleOrBody();

            state._fsp--;

             current =iv_ruleOrBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrBody"


    // $ANTLR start "ruleOrBody"
    // InternalTurn.g:5054:1: ruleOrBody returns [EObject current=null] : this_ElseOrForkBody_0= ruleElseOrForkBody ;
    public final EObject ruleOrBody() throws RecognitionException {
        EObject current = null;

        EObject this_ElseOrForkBody_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5060:2: (this_ElseOrForkBody_0= ruleElseOrForkBody )
            // InternalTurn.g:5061:2: this_ElseOrForkBody_0= ruleElseOrForkBody
            {

            		newCompositeNode(grammarAccess.getOrBodyAccess().getElseOrForkBodyParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ElseOrForkBody_0=ruleElseOrForkBody();

            state._fsp--;


            		current = this_ElseOrForkBody_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrBody"


    // $ANTLR start "entryRuleElseOrForkBody"
    // InternalTurn.g:5072:1: entryRuleElseOrForkBody returns [EObject current=null] : iv_ruleElseOrForkBody= ruleElseOrForkBody EOF ;
    public final EObject entryRuleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseOrForkBody = null;


        try {
            // InternalTurn.g:5072:55: (iv_ruleElseOrForkBody= ruleElseOrForkBody EOF )
            // InternalTurn.g:5073:2: iv_ruleElseOrForkBody= ruleElseOrForkBody EOF
            {
             newCompositeNode(grammarAccess.getElseOrForkBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElseOrForkBody=ruleElseOrForkBody();

            state._fsp--;

             current =iv_ruleElseOrForkBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseOrForkBody"


    // $ANTLR start "ruleElseOrForkBody"
    // InternalTurn.g:5079:1: ruleElseOrForkBody returns [EObject current=null] : (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) ;
    public final EObject ruleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_OrForkBody_0 = null;

        EObject lv_elseBody_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5085:2: ( (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) )
            // InternalTurn.g:5086:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            {
            // InternalTurn.g:5086:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            // InternalTurn.g:5087:3: this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            {

            			newCompositeNode(grammarAccess.getElseOrForkBodyAccess().getOrForkBodyParserRuleCall_0());
            		
            pushFollow(FOLLOW_96);
            this_OrForkBody_0=ruleOrForkBody();

            state._fsp--;


            			current = this_OrForkBody_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:5095:3: (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==83) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalTurn.g:5096:4: otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) )
                    {
                    otherlv_1=(Token)match(input,83,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getElseOrForkBodyAccess().getElseKeyword_1_0());
                    			
                    // InternalTurn.g:5100:4: ( (lv_elseBody_2_0= rulePathBody ) )
                    // InternalTurn.g:5101:5: (lv_elseBody_2_0= rulePathBody )
                    {
                    // InternalTurn.g:5101:5: (lv_elseBody_2_0= rulePathBody )
                    // InternalTurn.g:5102:6: lv_elseBody_2_0= rulePathBody
                    {

                    						newCompositeNode(grammarAccess.getElseOrForkBodyAccess().getElseBodyPathBodyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_elseBody_2_0=rulePathBody();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getElseOrForkBodyRule());
                    						}
                    						set(
                    							current,
                    							"elseBody",
                    							lv_elseBody_2_0,
                    							"org.jucmnav.turn.Turn.PathBody");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseOrForkBody"


    // $ANTLR start "entryRuleOrForkBody"
    // InternalTurn.g:5124:1: entryRuleOrForkBody returns [EObject current=null] : iv_ruleOrForkBody= ruleOrForkBody EOF ;
    public final EObject entryRuleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrForkBody = null;


        try {
            // InternalTurn.g:5124:51: (iv_ruleOrForkBody= ruleOrForkBody EOF )
            // InternalTurn.g:5125:2: iv_ruleOrForkBody= ruleOrForkBody EOF
            {
             newCompositeNode(grammarAccess.getOrForkBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrForkBody=ruleOrForkBody();

            state._fsp--;

             current =iv_ruleOrForkBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrForkBody"


    // $ANTLR start "ruleOrForkBody"
    // InternalTurn.g:5131:1: ruleOrForkBody returns [EObject current=null] : ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ ;
    public final EObject ruleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject lv_regularBody_0_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5137:2: ( ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ )
            // InternalTurn.g:5138:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            {
            // InternalTurn.g:5138:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            int cnt97=0;
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==24) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalTurn.g:5139:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    {
            	    // InternalTurn.g:5139:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    // InternalTurn.g:5140:4: lv_regularBody_0_0= ruleRegularOrFork
            	    {

            	    				newCompositeNode(grammarAccess.getOrForkBodyAccess().getRegularBodyRegularOrForkParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_66);
            	    lv_regularBody_0_0=ruleRegularOrFork();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getOrForkBodyRule());
            	    				}
            	    				add(
            	    					current,
            	    					"regularBody",
            	    					lv_regularBody_0_0,
            	    					"org.jucmnav.turn.Turn.RegularOrFork");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt97 >= 1 ) break loop97;
                        EarlyExitException eee =
                            new EarlyExitException(97, input);
                        throw eee;
                }
                cnt97++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrForkBody"


    // $ANTLR start "entryRuleRegularOrFork"
    // InternalTurn.g:5160:1: entryRuleRegularOrFork returns [EObject current=null] : iv_ruleRegularOrFork= ruleRegularOrFork EOF ;
    public final EObject entryRuleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularOrFork = null;


        try {
            // InternalTurn.g:5160:54: (iv_ruleRegularOrFork= ruleRegularOrFork EOF )
            // InternalTurn.g:5161:2: iv_ruleRegularOrFork= ruleRegularOrFork EOF
            {
             newCompositeNode(grammarAccess.getRegularOrForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularOrFork=ruleRegularOrFork();

            state._fsp--;

             current =iv_ruleRegularOrFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularOrFork"


    // $ANTLR start "ruleRegularOrFork"
    // InternalTurn.g:5167:1: ruleRegularOrFork returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject ruleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5173:2: ( ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTurn.g:5174:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTurn.g:5174:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTurn.g:5175:3: ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTurn.g:5175:3: ( (lv_condition_0_0= ruleCondition ) )
            // InternalTurn.g:5176:4: (lv_condition_0_0= ruleCondition )
            {
            // InternalTurn.g:5176:4: (lv_condition_0_0= ruleCondition )
            // InternalTurn.g:5177:5: lv_condition_0_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getRegularOrForkAccess().getConditionConditionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_63);
            lv_condition_0_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularOrForkRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_0_0,
            						"org.jucmnav.turn.Turn.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5194:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTurn.g:5195:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTurn.g:5195:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTurn.g:5196:5: lv_pathBody_1_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getRegularOrForkAccess().getPathBodyPathBodyParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_pathBody_1_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularOrForkRule());
            					}
            					set(
            						current,
            						"pathBody",
            						lv_pathBody_1_0,
            						"org.jucmnav.turn.Turn.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularOrFork"


    // $ANTLR start "entryRuleAndFork"
    // InternalTurn.g:5217:1: entryRuleAndFork returns [EObject current=null] : iv_ruleAndFork= ruleAndFork EOF ;
    public final EObject entryRuleAndFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndFork = null;


        try {
            // InternalTurn.g:5217:48: (iv_ruleAndFork= ruleAndFork EOF )
            // InternalTurn.g:5218:2: iv_ruleAndFork= ruleAndFork EOF
            {
             newCompositeNode(grammarAccess.getAndForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndFork=ruleAndFork();

            state._fsp--;

             current =iv_ruleAndFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndFork"


    // $ANTLR start "ruleAndFork"
    // InternalTurn.g:5224:1: ruleAndFork returns [EObject current=null] : (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? ) ;
    public final EObject ruleAndFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_pathbody_5_0 = null;

        EObject lv_connectingAndBody_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5230:2: ( (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? ) )
            // InternalTurn.g:5231:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? )
            {
            // InternalTurn.g:5231:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? )
            // InternalTurn.g:5232:3: otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )?
            {
            otherlv_0=(Token)match(input,84,FOLLOW_97); 

            			newLeafNode(otherlv_0, grammarAccess.getAndForkAccess().getAndKeyword_0());
            		
            // InternalTurn.g:5236:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==RULE_ID) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalTurn.g:5237:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:5237:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:5238:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:5238:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:5239:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getAndForkAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndForkRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.jucmnav.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:5256:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:5257:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:5257:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:5258:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getAndForkAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndForkRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.jucmnav.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_98); 

            			newLeafNode(otherlv_3, grammarAccess.getAndForkAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTurn.g:5280:3: (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==36) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalTurn.g:5281:4: otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) )
            	    {
            	    otherlv_4=(Token)match(input,36,FOLLOW_63); 

            	    				newLeafNode(otherlv_4, grammarAccess.getAndForkAccess().getAsteriskKeyword_3_0());
            	    			
            	    // InternalTurn.g:5285:4: ( (lv_pathbody_5_0= rulePathBody ) )
            	    // InternalTurn.g:5286:5: (lv_pathbody_5_0= rulePathBody )
            	    {
            	    // InternalTurn.g:5286:5: (lv_pathbody_5_0= rulePathBody )
            	    // InternalTurn.g:5287:6: lv_pathbody_5_0= rulePathBody
            	    {

            	    						newCompositeNode(grammarAccess.getAndForkAccess().getPathbodyPathBodyParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_98);
            	    lv_pathbody_5_0=rulePathBody();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndForkRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pathbody",
            	    							lv_pathbody_5_0,
            	    							"org.jucmnav.turn.Turn.PathBody");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_76); 

            			newLeafNode(otherlv_6, grammarAccess.getAndForkAccess().getRightCurlyBracketKeyword_4());
            		
            // InternalTurn.g:5309:3: ( (lv_connectingAndBody_7_0= rulePathBody ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==70) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalTurn.g:5310:4: (lv_connectingAndBody_7_0= rulePathBody )
                    {
                    // InternalTurn.g:5310:4: (lv_connectingAndBody_7_0= rulePathBody )
                    // InternalTurn.g:5311:5: lv_connectingAndBody_7_0= rulePathBody
                    {

                    					newCompositeNode(grammarAccess.getAndForkAccess().getConnectingAndBodyPathBodyParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_connectingAndBody_7_0=rulePathBody();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAndForkRule());
                    					}
                    					set(
                    						current,
                    						"connectingAndBody",
                    						lv_connectingAndBody_7_0,
                    						"org.jucmnav.turn.Turn.PathBody");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndFork"


    // $ANTLR start "entryRuleStub"
    // InternalTurn.g:5332:1: entryRuleStub returns [EObject current=null] : iv_ruleStub= ruleStub EOF ;
    public final EObject entryRuleStub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStub = null;


        try {
            // InternalTurn.g:5332:45: (iv_ruleStub= ruleStub EOF )
            // InternalTurn.g:5333:2: iv_ruleStub= ruleStub EOF
            {
             newCompositeNode(grammarAccess.getStubRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStub=ruleStub();

            state._fsp--;

             current =iv_ruleStub; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStub"


    // $ANTLR start "ruleStub"
    // InternalTurn.g:5339:1: ruleStub returns [EObject current=null] : ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? ) ;
    public final EObject ruleStub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_stubType_0_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_longName_5_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_outPaths_9_0 = null;

        EObject lv_connectingStubBody_11_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5345:2: ( ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? ) )
            // InternalTurn.g:5346:2: ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? )
            {
            // InternalTurn.g:5346:2: ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? )
            // InternalTurn.g:5347:3: ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )?
            {
            // InternalTurn.g:5347:3: ( (lv_stubType_0_0= ruleStubType ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( ((LA101_0>=130 && LA101_0<=131)) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalTurn.g:5348:4: (lv_stubType_0_0= ruleStubType )
                    {
                    // InternalTurn.g:5348:4: (lv_stubType_0_0= ruleStubType )
                    // InternalTurn.g:5349:5: lv_stubType_0_0= ruleStubType
                    {

                    					newCompositeNode(grammarAccess.getStubAccess().getStubTypeStubTypeEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_99);
                    lv_stubType_0_0=ruleStubType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStubRule());
                    					}
                    					set(
                    						current,
                    						"stubType",
                    						lv_stubType_0_0,
                    						"org.jucmnav.turn.Turn.StubType");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,85,FOLLOW_100); 

            			newLeafNode(otherlv_1, grammarAccess.getStubAccess().getStubKeyword_1());
            		
            // InternalTurn.g:5370:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==69) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalTurn.g:5371:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
                    {
                    otherlv_2=(Token)match(input,69,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubAccess().getInKeyword_2_0());
                    			
                    // InternalTurn.g:5375:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTurn.g:5376:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5376:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTurn.g:5377:6: lv_index_3_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getStubAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_101);
                    lv_index_3_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStubRule());
                    						}
                    						set(
                    							current,
                    							"index",
                    							lv_index_3_0,
                    							"org.jucmnav.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:5395:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )
            int alt104=2;
            alt104 = dfa104.predict(input);
            switch (alt104) {
                case 1 :
                    // InternalTurn.g:5396:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    {
                    // InternalTurn.g:5396:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    // InternalTurn.g:5397:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) )
                    {
                    // InternalTurn.g:5397:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( (LA103_0==RULE_ID) ) {
                        alt103=1;
                    }
                    switch (alt103) {
                        case 1 :
                            // InternalTurn.g:5398:6: ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) )
                            {
                            // InternalTurn.g:5398:6: ( (lv_name_4_0= ruleQualifiedName ) )
                            // InternalTurn.g:5399:7: (lv_name_4_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:5399:7: (lv_name_4_0= ruleQualifiedName )
                            // InternalTurn.g:5400:8: lv_name_4_0= ruleQualifiedName
                            {

                            								newCompositeNode(grammarAccess.getStubAccess().getNameQualifiedNameParserRuleCall_3_0_0_0_0());
                            							
                            pushFollow(FOLLOW_102);
                            lv_name_4_0=ruleQualifiedName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getStubRule());
                            								}
                            								set(
                            									current,
                            									"name",
                            									lv_name_4_0,
                            									"org.jucmnav.turn.Turn.QualifiedName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalTurn.g:5417:6: ( (lv_longName_5_0= ruleLongName ) )
                            // InternalTurn.g:5418:7: (lv_longName_5_0= ruleLongName )
                            {
                            // InternalTurn.g:5418:7: (lv_longName_5_0= ruleLongName )
                            // InternalTurn.g:5419:8: lv_longName_5_0= ruleLongName
                            {

                            								newCompositeNode(grammarAccess.getStubAccess().getLongNameLongNameParserRuleCall_3_0_0_1_0());
                            							
                            pushFollow(FOLLOW_101);
                            lv_longName_5_0=ruleLongName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getStubRule());
                            								}
                            								set(
                            									current,
                            									"longName",
                            									lv_longName_5_0,
                            									"org.jucmnav.turn.Turn.LongName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalTurn.g:5437:5: ( (lv_params_6_0= ruleStubParameters ) )
                    // InternalTurn.g:5438:6: (lv_params_6_0= ruleStubParameters )
                    {
                    // InternalTurn.g:5438:6: (lv_params_6_0= ruleStubParameters )
                    // InternalTurn.g:5439:7: lv_params_6_0= ruleStubParameters
                    {

                    							newCompositeNode(grammarAccess.getStubAccess().getParamsStubParametersParserRuleCall_3_0_1_0());
                    						
                    pushFollow(FOLLOW_103);
                    lv_params_6_0=ruleStubParameters();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStubRule());
                    							}
                    							set(
                    								current,
                    								"params",
                    								lv_params_6_0,
                    								"org.jucmnav.turn.Turn.StubParameters");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:5458:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalTurn.g:5458:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:5459:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:5459:5: ( ruleQualifiedName )
                    // InternalTurn.g:5460:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStubRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStubAccess().getStubRefStubDeclarationCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_103);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:5475:3: (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==13) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalTurn.g:5476:4: otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,13,FOLLOW_104); 

                    				newLeafNode(otherlv_8, grammarAccess.getStubAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalTurn.g:5480:4: ( (lv_outPaths_9_0= ruleStubOutPath ) )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==88) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // InternalTurn.g:5481:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    {
                    	    // InternalTurn.g:5481:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    // InternalTurn.g:5482:6: lv_outPaths_9_0= ruleStubOutPath
                    	    {

                    	    						newCompositeNode(grammarAccess.getStubAccess().getOutPathsStubOutPathParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_104);
                    	    lv_outPaths_9_0=ruleStubOutPath();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStubRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"outPaths",
                    	    							lv_outPaths_9_0,
                    	    							"org.jucmnav.turn.Turn.StubOutPath");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop105;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,20,FOLLOW_76); 

                    				newLeafNode(otherlv_10, grammarAccess.getStubAccess().getRightCurlyBracketKeyword_4_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5504:3: ( (lv_connectingStubBody_11_0= rulePathBody ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==70) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalTurn.g:5505:4: (lv_connectingStubBody_11_0= rulePathBody )
                    {
                    // InternalTurn.g:5505:4: (lv_connectingStubBody_11_0= rulePathBody )
                    // InternalTurn.g:5506:5: lv_connectingStubBody_11_0= rulePathBody
                    {

                    					newCompositeNode(grammarAccess.getStubAccess().getConnectingStubBodyPathBodyParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_connectingStubBody_11_0=rulePathBody();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStubRule());
                    					}
                    					set(
                    						current,
                    						"connectingStubBody",
                    						lv_connectingStubBody_11_0,
                    						"org.jucmnav.turn.Turn.PathBody");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStub"


    // $ANTLR start "entryRuleStubParameters"
    // InternalTurn.g:5527:1: entryRuleStubParameters returns [EObject current=null] : iv_ruleStubParameters= ruleStubParameters EOF ;
    public final EObject entryRuleStubParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubParameters = null;


        try {
            // InternalTurn.g:5527:55: (iv_ruleStubParameters= ruleStubParameters EOF )
            // InternalTurn.g:5528:2: iv_ruleStubParameters= ruleStubParameters EOF
            {
             newCompositeNode(grammarAccess.getStubParametersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubParameters=ruleStubParameters();

            state._fsp--;

             current =iv_ruleStubParameters; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubParameters"


    // $ANTLR start "ruleStubParameters"
    // InternalTurn.g:5534:1: ruleStubParameters returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) ;
    public final EObject ruleStubParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_plugin_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5540:2: ( ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) )
            // InternalTurn.g:5541:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            {
            // InternalTurn.g:5541:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            // InternalTurn.g:5542:3: () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')'
            {
            // InternalTurn.g:5542:3: ()
            // InternalTurn.g:5543:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStubParametersAccess().getStubParametersAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,86,FOLLOW_105); 

            			newLeafNode(otherlv_1, grammarAccess.getStubParametersAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTurn.g:5553:3: ( (lv_plugin_2_0= rulePluginBinding ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==RULE_ID||LA108_0==24||LA108_0==89) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalTurn.g:5554:4: (lv_plugin_2_0= rulePluginBinding )
            	    {
            	    // InternalTurn.g:5554:4: (lv_plugin_2_0= rulePluginBinding )
            	    // InternalTurn.g:5555:5: lv_plugin_2_0= rulePluginBinding
            	    {

            	    					newCompositeNode(grammarAccess.getStubParametersAccess().getPluginPluginBindingParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_105);
            	    lv_plugin_2_0=rulePluginBinding();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStubParametersRule());
            	    					}
            	    					add(
            	    						current,
            	    						"plugin",
            	    						lv_plugin_2_0,
            	    						"org.jucmnav.turn.Turn.PluginBinding");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);

            otherlv_3=(Token)match(input,87,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getStubParametersAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubParameters"


    // $ANTLR start "entryRuleStubDeclaration"
    // InternalTurn.g:5580:1: entryRuleStubDeclaration returns [EObject current=null] : iv_ruleStubDeclaration= ruleStubDeclaration EOF ;
    public final EObject entryRuleStubDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubDeclaration = null;


        try {
            // InternalTurn.g:5580:56: (iv_ruleStubDeclaration= ruleStubDeclaration EOF )
            // InternalTurn.g:5581:2: iv_ruleStubDeclaration= ruleStubDeclaration EOF
            {
             newCompositeNode(grammarAccess.getStubDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubDeclaration=ruleStubDeclaration();

            state._fsp--;

             current =iv_ruleStubDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubDeclaration"


    // $ANTLR start "ruleStubDeclaration"
    // InternalTurn.g:5587:1: ruleStubDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) ;
    public final EObject ruleStubDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        EObject lv_params_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5593:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) )
            // InternalTurn.g:5594:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            {
            // InternalTurn.g:5594:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            // InternalTurn.g:5595:3: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) )
            {
            // InternalTurn.g:5595:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalTurn.g:5596:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalTurn.g:5596:4: (lv_name_0_0= ruleQualifiedName )
            // InternalTurn.g:5597:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_106);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5614:3: ( (lv_longName_1_0= ruleLongName ) )
            // InternalTurn.g:5615:4: (lv_longName_1_0= ruleLongName )
            {
            // InternalTurn.g:5615:4: (lv_longName_1_0= ruleLongName )
            // InternalTurn.g:5616:5: lv_longName_1_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getLongNameLongNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_23);
            lv_longName_1_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_1_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_101); 

            			newLeafNode(otherlv_2, grammarAccess.getStubDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalTurn.g:5637:3: ( (lv_params_3_0= ruleStubParameters ) )
            // InternalTurn.g:5638:4: (lv_params_3_0= ruleStubParameters )
            {
            // InternalTurn.g:5638:4: (lv_params_3_0= ruleStubParameters )
            // InternalTurn.g:5639:5: lv_params_3_0= ruleStubParameters
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getParamsStubParametersParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_params_3_0=ruleStubParameters();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"params",
            						lv_params_3_0,
            						"org.jucmnav.turn.Turn.StubParameters");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubDeclaration"


    // $ANTLR start "entryRuleStubOutPath"
    // InternalTurn.g:5660:1: entryRuleStubOutPath returns [EObject current=null] : iv_ruleStubOutPath= ruleStubOutPath EOF ;
    public final EObject entryRuleStubOutPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubOutPath = null;


        try {
            // InternalTurn.g:5660:52: (iv_ruleStubOutPath= ruleStubOutPath EOF )
            // InternalTurn.g:5661:2: iv_ruleStubOutPath= ruleStubOutPath EOF
            {
             newCompositeNode(grammarAccess.getStubOutPathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubOutPath=ruleStubOutPath();

            state._fsp--;

             current =iv_ruleStubOutPath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubOutPath"


    // $ANTLR start "ruleStubOutPath"
    // InternalTurn.g:5667:1: ruleStubOutPath returns [EObject current=null] : ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) ;
    public final EObject ruleStubOutPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_index_1_0 = null;

        AntlrDatatypeRuleToken lv_threshold_4_0 = null;

        EObject lv_path_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5673:2: ( ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) )
            // InternalTurn.g:5674:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            {
            // InternalTurn.g:5674:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            // InternalTurn.g:5675:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) )
            {
            // InternalTurn.g:5675:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) )
            // InternalTurn.g:5676:4: otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) )
            {
            otherlv_0=(Token)match(input,88,FOLLOW_54); 

            				newLeafNode(otherlv_0, grammarAccess.getStubOutPathAccess().getOutKeyword_0_0());
            			
            // InternalTurn.g:5680:4: ( (lv_index_1_0= rulePositiveInteger ) )
            // InternalTurn.g:5681:5: (lv_index_1_0= rulePositiveInteger )
            {
            // InternalTurn.g:5681:5: (lv_index_1_0= rulePositiveInteger )
            // InternalTurn.g:5682:6: lv_index_1_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getStubOutPathAccess().getIndexPositiveIntegerParserRuleCall_0_1_0());
            					
            pushFollow(FOLLOW_107);
            lv_index_1_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getStubOutPathRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_1_0,
            							"org.jucmnav.turn.Turn.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            // InternalTurn.g:5700:3: (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==55) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalTurn.g:5701:4: otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']'
                    {
                    otherlv_2=(Token)match(input,55,FOLLOW_90); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubOutPathAccess().getThresholdKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,24,FOLLOW_54); 

                    				newLeafNode(otherlv_3, grammarAccess.getStubOutPathAccess().getLeftSquareBracketKeyword_1_1());
                    			
                    // InternalTurn.g:5709:4: ( (lv_threshold_4_0= rulePositiveInteger ) )
                    // InternalTurn.g:5710:5: (lv_threshold_4_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5710:5: (lv_threshold_4_0= rulePositiveInteger )
                    // InternalTurn.g:5711:6: lv_threshold_4_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getStubOutPathAccess().getThresholdPositiveIntegerParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_threshold_4_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStubOutPathRule());
                    						}
                    						set(
                    							current,
                    							"threshold",
                    							lv_threshold_4_0,
                    							"org.jucmnav.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,25,FOLLOW_63); 

                    				newLeafNode(otherlv_5, grammarAccess.getStubOutPathAccess().getRightSquareBracketKeyword_1_3());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5733:3: ( (lv_path_6_0= rulePathBody ) )
            // InternalTurn.g:5734:4: (lv_path_6_0= rulePathBody )
            {
            // InternalTurn.g:5734:4: (lv_path_6_0= rulePathBody )
            // InternalTurn.g:5735:5: lv_path_6_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getStubOutPathAccess().getPathPathBodyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_path_6_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubOutPathRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_6_0,
            						"org.jucmnav.turn.Turn.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubOutPath"


    // $ANTLR start "entryRulePluginBinding"
    // InternalTurn.g:5756:1: entryRulePluginBinding returns [EObject current=null] : iv_rulePluginBinding= rulePluginBinding EOF ;
    public final EObject entryRulePluginBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginBinding = null;


        try {
            // InternalTurn.g:5756:54: (iv_rulePluginBinding= rulePluginBinding EOF )
            // InternalTurn.g:5757:2: iv_rulePluginBinding= rulePluginBinding EOF
            {
             newCompositeNode(grammarAccess.getPluginBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePluginBinding=rulePluginBinding();

            state._fsp--;

             current =iv_rulePluginBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePluginBinding"


    // $ANTLR start "rulePluginBinding"
    // InternalTurn.g:5763:1: rulePluginBinding returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) ;
    public final EObject rulePluginBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_0_0 = null;

        AntlrDatatypeRuleToken lv_replication_2_0 = null;

        EObject lv_binding_5_0 = null;

        EObject lv_bindings_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5769:2: ( ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) )
            // InternalTurn.g:5770:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            {
            // InternalTurn.g:5770:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            // InternalTurn.g:5771:3: ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            {
            // InternalTurn.g:5771:3: ( (lv_condition_0_0= ruleCondition ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==24) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalTurn.g:5772:4: (lv_condition_0_0= ruleCondition )
                    {
                    // InternalTurn.g:5772:4: (lv_condition_0_0= ruleCondition )
                    // InternalTurn.g:5773:5: lv_condition_0_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getPluginBindingAccess().getConditionConditionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_108);
                    lv_condition_0_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_0_0,
                    						"org.jucmnav.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:5790:3: (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==89) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalTurn.g:5791:4: otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) )
                    {
                    otherlv_1=(Token)match(input,89,FOLLOW_54); 

                    				newLeafNode(otherlv_1, grammarAccess.getPluginBindingAccess().getReplicationKeyword_1_0());
                    			
                    // InternalTurn.g:5795:4: ( (lv_replication_2_0= rulePositiveInteger ) )
                    // InternalTurn.g:5796:5: (lv_replication_2_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5796:5: (lv_replication_2_0= rulePositiveInteger )
                    // InternalTurn.g:5797:6: lv_replication_2_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getPluginBindingAccess().getReplicationPositiveIntegerParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_replication_2_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    						}
                    						set(
                    							current,
                    							"replication",
                    							lv_replication_2_0,
                    							"org.jucmnav.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:5815:3: ( (otherlv_3= RULE_ID ) )
            // InternalTurn.g:5816:4: (otherlv_3= RULE_ID )
            {
            // InternalTurn.g:5816:4: (otherlv_3= RULE_ID )
            // InternalTurn.g:5817:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPluginBindingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_109); 

            					newLeafNode(otherlv_3, grammarAccess.getPluginBindingAccess().getMapUCMmapCrossReference_2_0());
            				

            }


            }

            // InternalTurn.g:5828:3: (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==22) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalTurn.g:5829:4: otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getPluginBindingAccess().getColonKeyword_3_0());
                    			
                    // InternalTurn.g:5833:4: ( (lv_binding_5_0= ruleBinding ) )
                    // InternalTurn.g:5834:5: (lv_binding_5_0= ruleBinding )
                    {
                    // InternalTurn.g:5834:5: (lv_binding_5_0= ruleBinding )
                    // InternalTurn.g:5835:6: lv_binding_5_0= ruleBinding
                    {

                    						newCompositeNode(grammarAccess.getPluginBindingAccess().getBindingBindingParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_binding_5_0=ruleBinding();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    						}
                    						set(
                    							current,
                    							"binding",
                    							lv_binding_5_0,
                    							"org.jucmnav.turn.Turn.Binding");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:5852:4: (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    loop112:
                    do {
                        int alt112=2;
                        int LA112_0 = input.LA(1);

                        if ( (LA112_0==23) ) {
                            alt112=1;
                        }


                        switch (alt112) {
                    	case 1 :
                    	    // InternalTurn.g:5853:5: otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getPluginBindingAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalTurn.g:5857:5: ( (lv_bindings_7_0= ruleBinding ) )
                    	    // InternalTurn.g:5858:6: (lv_bindings_7_0= ruleBinding )
                    	    {
                    	    // InternalTurn.g:5858:6: (lv_bindings_7_0= ruleBinding )
                    	    // InternalTurn.g:5859:7: lv_bindings_7_0= ruleBinding
                    	    {

                    	    							newCompositeNode(grammarAccess.getPluginBindingAccess().getBindingsBindingParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
                    	    lv_bindings_7_0=ruleBinding();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"bindings",
                    	    								lv_bindings_7_0,
                    	    								"org.jucmnav.turn.Turn.Binding");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop112;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePluginBinding"


    // $ANTLR start "entryRuleComponentRef"
    // InternalTurn.g:5882:1: entryRuleComponentRef returns [EObject current=null] : iv_ruleComponentRef= ruleComponentRef EOF ;
    public final EObject entryRuleComponentRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentRef = null;


        try {
            // InternalTurn.g:5882:53: (iv_ruleComponentRef= ruleComponentRef EOF )
            // InternalTurn.g:5883:2: iv_ruleComponentRef= ruleComponentRef EOF
            {
             newCompositeNode(grammarAccess.getComponentRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentRef=ruleComponentRef();

            state._fsp--;

             current =iv_ruleComponentRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentRef"


    // $ANTLR start "ruleComponentRef"
    // InternalTurn.g:5889:1: ruleComponentRef returns [EObject current=null] : ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleComponentKind ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) ;
    public final EObject ruleComponentRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_kind_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_element_5_0 = null;

        EObject lv_elements_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5895:2: ( ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleComponentKind ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) )
            // InternalTurn.g:5896:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleComponentKind ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            {
            // InternalTurn.g:5896:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleComponentKind ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            // InternalTurn.g:5897:3: (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleComponentKind ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            {
            // InternalTurn.g:5897:3: (otherlv_0= 'protected' )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==90) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalTurn.g:5898:4: otherlv_0= 'protected'
                    {
                    otherlv_0=(Token)match(input,90,FOLLOW_110); 

                    				newLeafNode(otherlv_0, grammarAccess.getComponentRefAccess().getProtectedKeyword_0());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5903:3: ( (lv_kind_1_0= ruleComponentKind ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==38||(LA115_0>=123 && LA115_0<=127)) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalTurn.g:5904:4: (lv_kind_1_0= ruleComponentKind )
                    {
                    // InternalTurn.g:5904:4: (lv_kind_1_0= ruleComponentKind )
                    // InternalTurn.g:5905:5: lv_kind_1_0= ruleComponentKind
                    {

                    					newCompositeNode(grammarAccess.getComponentRefAccess().getKindComponentKindEnumRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_kind_1_0=ruleComponentKind();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_1_0,
                    						"org.jucmnav.turn.Turn.ComponentKind");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:5922:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:5923:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:5923:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:5924:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getComponentRefAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5941:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:5942:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:5942:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:5943:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getComponentRefAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_109);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5960:3: (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==22) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalTurn.g:5961:4: otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getComponentRefAccess().getColonKeyword_4_0());
                    			
                    // InternalTurn.g:5965:4: ( (lv_element_5_0= ruleBoundOption ) )
                    // InternalTurn.g:5966:5: (lv_element_5_0= ruleBoundOption )
                    {
                    // InternalTurn.g:5966:5: (lv_element_5_0= ruleBoundOption )
                    // InternalTurn.g:5967:6: lv_element_5_0= ruleBoundOption
                    {

                    						newCompositeNode(grammarAccess.getComponentRefAccess().getElementBoundOptionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_element_5_0=ruleBoundOption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    						}
                    						set(
                    							current,
                    							"element",
                    							lv_element_5_0,
                    							"org.jucmnav.turn.Turn.BoundOption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:5984:4: (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==23) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // InternalTurn.g:5985:5: otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getComponentRefAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalTurn.g:5989:5: ( (lv_elements_7_0= ruleBoundOption ) )
                    	    // InternalTurn.g:5990:6: (lv_elements_7_0= ruleBoundOption )
                    	    {
                    	    // InternalTurn.g:5990:6: (lv_elements_7_0= ruleBoundOption )
                    	    // InternalTurn.g:5991:7: lv_elements_7_0= ruleBoundOption
                    	    {

                    	    							newCompositeNode(grammarAccess.getComponentRefAccess().getElementsBoundOptionParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
                    	    lv_elements_7_0=ruleBoundOption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_7_0,
                    	    								"org.jucmnav.turn.Turn.BoundOption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop116;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentRef"


    // $ANTLR start "entryRuleBoundOption"
    // InternalTurn.g:6014:1: entryRuleBoundOption returns [EObject current=null] : iv_ruleBoundOption= ruleBoundOption EOF ;
    public final EObject entryRuleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundOption = null;


        try {
            // InternalTurn.g:6014:52: (iv_ruleBoundOption= ruleBoundOption EOF )
            // InternalTurn.g:6015:2: iv_ruleBoundOption= ruleBoundOption EOF
            {
             newCompositeNode(grammarAccess.getBoundOptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoundOption=ruleBoundOption();

            state._fsp--;

             current =iv_ruleBoundOption; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoundOption"


    // $ANTLR start "ruleBoundOption"
    // InternalTurn.g:6021:1: ruleBoundOption returns [EObject current=null] : (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) ;
    public final EObject ruleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject this_BoundElement_0 = null;

        EObject this_LongBoundElement_1 = null;



        	enterRule();

        try {
            // InternalTurn.g:6027:2: ( (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) )
            // InternalTurn.g:6028:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            {
            // InternalTurn.g:6028:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            int alt118=2;
            alt118 = dfa118.predict(input);
            switch (alt118) {
                case 1 :
                    // InternalTurn.g:6029:3: this_BoundElement_0= ruleBoundElement
                    {

                    			newCompositeNode(grammarAccess.getBoundOptionAccess().getBoundElementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoundElement_0=ruleBoundElement();

                    state._fsp--;


                    			current = this_BoundElement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:6038:3: this_LongBoundElement_1= ruleLongBoundElement
                    {

                    			newCompositeNode(grammarAccess.getBoundOptionAccess().getLongBoundElementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongBoundElement_1=ruleLongBoundElement();

                    state._fsp--;


                    			current = this_LongBoundElement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoundOption"


    // $ANTLR start "entryRuleBoundElement"
    // InternalTurn.g:6050:1: entryRuleBoundElement returns [EObject current=null] : iv_ruleBoundElement= ruleBoundElement EOF ;
    public final EObject entryRuleBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundElement = null;


        try {
            // InternalTurn.g:6050:53: (iv_ruleBoundElement= ruleBoundElement EOF )
            // InternalTurn.g:6051:2: iv_ruleBoundElement= ruleBoundElement EOF
            {
             newCompositeNode(grammarAccess.getBoundElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoundElement=ruleBoundElement();

            state._fsp--;

             current =iv_ruleBoundElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoundElement"


    // $ANTLR start "ruleBoundElement"
    // InternalTurn.g:6057:1: ruleBoundElement returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleBoundElement() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalTurn.g:6063:2: ( ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:6064:2: ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:6064:2: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6065:3: ( ruleQualifiedName )
            {
            // InternalTurn.g:6065:3: ( ruleQualifiedName )
            // InternalTurn.g:6066:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBoundElementRule());
            				}
            			

            				newCompositeNode(grammarAccess.getBoundElementAccess().getElemReferencedBoundElementCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoundElement"


    // $ANTLR start "entryRuleLongBoundElement"
    // InternalTurn.g:6083:1: entryRuleLongBoundElement returns [EObject current=null] : iv_ruleLongBoundElement= ruleLongBoundElement EOF ;
    public final EObject entryRuleLongBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongBoundElement = null;


        try {
            // InternalTurn.g:6083:57: (iv_ruleLongBoundElement= ruleLongBoundElement EOF )
            // InternalTurn.g:6084:2: iv_ruleLongBoundElement= ruleLongBoundElement EOF
            {
             newCompositeNode(grammarAccess.getLongBoundElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongBoundElement=ruleLongBoundElement();

            state._fsp--;

             current =iv_ruleLongBoundElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongBoundElement"


    // $ANTLR start "ruleLongBoundElement"
    // InternalTurn.g:6090:1: ruleLongBoundElement returns [EObject current=null] : ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleLongBoundElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_from_0_0 = null;

        AntlrDatatypeRuleToken lv_to_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6096:2: ( ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) )
            // InternalTurn.g:6097:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            {
            // InternalTurn.g:6097:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            // InternalTurn.g:6098:3: ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) )
            {
            // InternalTurn.g:6098:3: ( (lv_from_0_0= ruleQualifiedName ) )
            // InternalTurn.g:6099:4: (lv_from_0_0= ruleQualifiedName )
            {
            // InternalTurn.g:6099:4: (lv_from_0_0= ruleQualifiedName )
            // InternalTurn.g:6100:5: lv_from_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLongBoundElementAccess().getFromQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_111);
            lv_from_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLongBoundElementRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_0_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,91,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getLongBoundElementAccess().getFullStopFullStopKeyword_1());
            		
            // InternalTurn.g:6121:3: ( (lv_to_2_0= ruleQualifiedName ) )
            // InternalTurn.g:6122:4: (lv_to_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:6122:4: (lv_to_2_0= ruleQualifiedName )
            // InternalTurn.g:6123:5: lv_to_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLongBoundElementAccess().getToQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_to_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLongBoundElementRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_2_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongBoundElement"


    // $ANTLR start "entryRuleBinding"
    // InternalTurn.g:6144:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalTurn.g:6144:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalTurn.g:6145:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // InternalTurn.g:6151:1: ruleBinding returns [EObject current=null] : (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_InBinding_0 = null;

        EObject this_OutBinding_1 = null;

        EObject this_ComponentBinding_2 = null;



        	enterRule();

        try {
            // InternalTurn.g:6157:2: ( (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) )
            // InternalTurn.g:6158:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            {
            // InternalTurn.g:6158:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            int alt119=3;
            alt119 = dfa119.predict(input);
            switch (alt119) {
                case 1 :
                    // InternalTurn.g:6159:3: this_InBinding_0= ruleInBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getInBindingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InBinding_0=ruleInBinding();

                    state._fsp--;


                    			current = this_InBinding_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:6168:3: this_OutBinding_1= ruleOutBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getOutBindingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OutBinding_1=ruleOutBinding();

                    state._fsp--;


                    			current = this_OutBinding_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:6177:3: this_ComponentBinding_2= ruleComponentBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getComponentBindingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComponentBinding_2=ruleComponentBinding();

                    state._fsp--;


                    			current = this_ComponentBinding_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleInBinding"
    // InternalTurn.g:6189:1: entryRuleInBinding returns [EObject current=null] : iv_ruleInBinding= ruleInBinding EOF ;
    public final EObject entryRuleInBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInBinding = null;


        try {
            // InternalTurn.g:6189:50: (iv_ruleInBinding= ruleInBinding EOF )
            // InternalTurn.g:6190:2: iv_ruleInBinding= ruleInBinding EOF
            {
             newCompositeNode(grammarAccess.getInBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInBinding=ruleInBinding();

            state._fsp--;

             current =iv_ruleInBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBinding"


    // $ANTLR start "ruleInBinding"
    // InternalTurn.g:6196:1: ruleInBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleInBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6202:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTurn.g:6203:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTurn.g:6203:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTurn.g:6204:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTurn.g:6204:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6205:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6205:4: ( ruleQualifiedName )
            // InternalTurn.g:6206:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInBindingAccess().getMapStartStartPointCrossReference_0_0());
            				
            pushFollow(FOLLOW_23);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_112); 

            			newLeafNode(otherlv_1, grammarAccess.getInBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTurn.g:6224:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTurn.g:6225:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,69,FOLLOW_54); 

            				newLeafNode(otherlv_2, grammarAccess.getInBindingAccess().getInKeyword_2_0());
            			
            // InternalTurn.g:6229:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTurn.g:6230:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTurn.g:6230:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTurn.g:6231:6: lv_index_3_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getInBindingAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_index_3_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getInBindingRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_3_0,
            							"org.jucmnav.turn.Turn.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBinding"


    // $ANTLR start "entryRuleOutBinding"
    // InternalTurn.g:6253:1: entryRuleOutBinding returns [EObject current=null] : iv_ruleOutBinding= ruleOutBinding EOF ;
    public final EObject entryRuleOutBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutBinding = null;


        try {
            // InternalTurn.g:6253:51: (iv_ruleOutBinding= ruleOutBinding EOF )
            // InternalTurn.g:6254:2: iv_ruleOutBinding= ruleOutBinding EOF
            {
             newCompositeNode(grammarAccess.getOutBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutBinding=ruleOutBinding();

            state._fsp--;

             current =iv_ruleOutBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutBinding"


    // $ANTLR start "ruleOutBinding"
    // InternalTurn.g:6260:1: ruleOutBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleOutBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6266:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTurn.g:6267:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTurn.g:6267:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTurn.g:6268:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTurn.g:6268:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6269:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6269:4: ( ruleQualifiedName )
            // InternalTurn.g:6270:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOutBindingAccess().getMapEndEndPointCrossReference_0_0());
            				
            pushFollow(FOLLOW_23);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_113); 

            			newLeafNode(otherlv_1, grammarAccess.getOutBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTurn.g:6288:3: (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTurn.g:6289:4: otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,88,FOLLOW_54); 

            				newLeafNode(otherlv_2, grammarAccess.getOutBindingAccess().getOutKeyword_2_0());
            			
            // InternalTurn.g:6293:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTurn.g:6294:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTurn.g:6294:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTurn.g:6295:6: lv_index_3_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getOutBindingAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_index_3_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getOutBindingRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_3_0,
            							"org.jucmnav.turn.Turn.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutBinding"


    // $ANTLR start "entryRuleComponentBinding"
    // InternalTurn.g:6317:1: entryRuleComponentBinding returns [EObject current=null] : iv_ruleComponentBinding= ruleComponentBinding EOF ;
    public final EObject entryRuleComponentBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentBinding = null;


        try {
            // InternalTurn.g:6317:57: (iv_ruleComponentBinding= ruleComponentBinding EOF )
            // InternalTurn.g:6318:2: iv_ruleComponentBinding= ruleComponentBinding EOF
            {
             newCompositeNode(grammarAccess.getComponentBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentBinding=ruleComponentBinding();

            state._fsp--;

             current =iv_ruleComponentBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentBinding"


    // $ANTLR start "ruleComponentBinding"
    // InternalTurn.g:6324:1: ruleComponentBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleComponentBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTurn.g:6330:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:6331:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:6331:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:6332:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:6332:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6333:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6333:4: ( ruleQualifiedName )
            // InternalTurn.g:6334:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComponentBindingAccess().getComponentInComponentRefCrossReference_0_0());
            				
            pushFollow(FOLLOW_23);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getComponentBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTurn.g:6352:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6353:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6353:4: ( ruleQualifiedName )
            // InternalTurn.g:6354:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComponentBindingAccess().getComponentOutComponentRefCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentBinding"


    // $ANTLR start "entryRuleFailureLabel"
    // InternalTurn.g:6372:1: entryRuleFailureLabel returns [EObject current=null] : iv_ruleFailureLabel= ruleFailureLabel EOF ;
    public final EObject entryRuleFailureLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailureLabel = null;


        try {
            // InternalTurn.g:6372:53: (iv_ruleFailureLabel= ruleFailureLabel EOF )
            // InternalTurn.g:6373:2: iv_ruleFailureLabel= ruleFailureLabel EOF
            {
             newCompositeNode(grammarAccess.getFailureLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailureLabel=ruleFailureLabel();

            state._fsp--;

             current =iv_ruleFailureLabel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailureLabel"


    // $ANTLR start "ruleFailureLabel"
    // InternalTurn.g:6379:1: ruleFailureLabel returns [EObject current=null] : (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) ;
    public final EObject ruleFailureLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_failure_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTurn.g:6385:2: ( (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) )
            // InternalTurn.g:6386:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            {
            // InternalTurn.g:6386:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            // InternalTurn.g:6387:3: otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getFailureLabelAccess().getLeftSquareBracketLeftSquareBracketKeyword_0());
            		
            // InternalTurn.g:6391:3: ( (lv_failure_1_0= RULE_STRING ) )
            // InternalTurn.g:6392:4: (lv_failure_1_0= RULE_STRING )
            {
            // InternalTurn.g:6392:4: (lv_failure_1_0= RULE_STRING )
            // InternalTurn.g:6393:5: lv_failure_1_0= RULE_STRING
            {
            lv_failure_1_0=(Token)match(input,RULE_STRING,FOLLOW_70); 

            					newLeafNode(lv_failure_1_0, grammarAccess.getFailureLabelAccess().getFailureSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFailureLabelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"failure",
            						lv_failure_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,67,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getFailureLabelAccess().getRightSquareBracketRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailureLabel"


    // $ANTLR start "entryRuleScenarioGroup"
    // InternalTurn.g:6417:1: entryRuleScenarioGroup returns [EObject current=null] : iv_ruleScenarioGroup= ruleScenarioGroup EOF ;
    public final EObject entryRuleScenarioGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenarioGroup = null;


        try {
            // InternalTurn.g:6417:54: (iv_ruleScenarioGroup= ruleScenarioGroup EOF )
            // InternalTurn.g:6418:2: iv_ruleScenarioGroup= ruleScenarioGroup EOF
            {
             newCompositeNode(grammarAccess.getScenarioGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenarioGroup=ruleScenarioGroup();

            state._fsp--;

             current =iv_ruleScenarioGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenarioGroup"


    // $ANTLR start "ruleScenarioGroup"
    // InternalTurn.g:6424:1: ruleScenarioGroup returns [EObject current=null] : (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
    public final EObject ruleScenarioGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6430:2: ( (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTurn.g:6431:2: (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTurn.g:6431:2: (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTurn.g:6432:3: otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,92,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getScenarioGroupAccess().getScenarioGroupKeyword_0());
            		
            // InternalTurn.g:6436:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:6437:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:6437:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:6438:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getScenarioGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:6455:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:6456:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:6456:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:6457:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getScenarioGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getScenarioGroupAccess().getColonKeyword_3());
            		
            // InternalTurn.g:6478:3: ( (otherlv_4= RULE_ID ) )
            // InternalTurn.g:6479:4: (otherlv_4= RULE_ID )
            {
            // InternalTurn.g:6479:4: (otherlv_4= RULE_ID )
            // InternalTurn.g:6480:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScenarioGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getScenarioGroupAccess().getScenariosScenarioDefCrossReference_4_0());
            				

            }


            }

            // InternalTurn.g:6491:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==23) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalTurn.g:6492:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getScenarioGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:6496:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTurn.g:6497:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTurn.g:6497:5: (otherlv_6= RULE_ID )
            	    // InternalTurn.g:6498:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getScenarioGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_16); 

            	    						newLeafNode(otherlv_6, grammarAccess.getScenarioGroupAccess().getScenariosScenarioDefCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop120;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenarioGroup"


    // $ANTLR start "entryRuleScenarioDef"
    // InternalTurn.g:6514:1: entryRuleScenarioDef returns [EObject current=null] : iv_ruleScenarioDef= ruleScenarioDef EOF ;
    public final EObject entryRuleScenarioDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenarioDef = null;


        try {
            // InternalTurn.g:6514:52: (iv_ruleScenarioDef= ruleScenarioDef EOF )
            // InternalTurn.g:6515:2: iv_ruleScenarioDef= ruleScenarioDef EOF
            {
             newCompositeNode(grammarAccess.getScenarioDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenarioDef=ruleScenarioDef();

            state._fsp--;

             current =iv_ruleScenarioDef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenarioDef"


    // $ANTLR start "ruleScenarioDef"
    // InternalTurn.g:6521:1: ruleScenarioDef returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= 'end' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'includes' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? otherlv_22= '}' ) ;
    public final EObject ruleScenarioDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_preconditions_5_0 = null;

        EObject lv_postconditions_7_0 = null;

        EObject lv_initializations_9_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6527:2: ( (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= 'end' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'includes' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? otherlv_22= '}' ) )
            // InternalTurn.g:6528:2: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= 'end' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'includes' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? otherlv_22= '}' )
            {
            // InternalTurn.g:6528:2: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= 'end' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'includes' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? otherlv_22= '}' )
            // InternalTurn.g:6529:3: otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )? (otherlv_14= 'end' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )? (otherlv_18= 'includes' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? otherlv_22= '}'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getScenarioDefAccess().getScenarioKeyword_0());
            		
            // InternalTurn.g:6533:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:6534:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:6534:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:6535:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getScenarioDefAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.jucmnav.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:6552:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:6553:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:6553:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:6554:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getScenarioDefAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.jucmnav.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_114); 

            			newLeafNode(otherlv_3, grammarAccess.getScenarioDefAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:6575:3: (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==94) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // InternalTurn.g:6576:4: otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) )
            	    {
            	    otherlv_4=(Token)match(input,94,FOLLOW_90); 

            	    				newLeafNode(otherlv_4, grammarAccess.getScenarioDefAccess().getPreKeyword_4_0());
            	    			
            	    // InternalTurn.g:6580:4: ( (lv_preconditions_5_0= ruleCondition ) )
            	    // InternalTurn.g:6581:5: (lv_preconditions_5_0= ruleCondition )
            	    {
            	    // InternalTurn.g:6581:5: (lv_preconditions_5_0= ruleCondition )
            	    // InternalTurn.g:6582:6: lv_preconditions_5_0= ruleCondition
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioDefAccess().getPreconditionsConditionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_114);
            	    lv_preconditions_5_0=ruleCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"preconditions",
            	    							lv_preconditions_5_0,
            	    							"org.jucmnav.turn.Turn.Condition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop121;
                }
            } while (true);

            // InternalTurn.g:6600:3: (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==95) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // InternalTurn.g:6601:4: otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) )
            	    {
            	    otherlv_6=(Token)match(input,95,FOLLOW_90); 

            	    				newLeafNode(otherlv_6, grammarAccess.getScenarioDefAccess().getPostKeyword_5_0());
            	    			
            	    // InternalTurn.g:6605:4: ( (lv_postconditions_7_0= ruleCondition ) )
            	    // InternalTurn.g:6606:5: (lv_postconditions_7_0= ruleCondition )
            	    {
            	    // InternalTurn.g:6606:5: (lv_postconditions_7_0= ruleCondition )
            	    // InternalTurn.g:6607:6: lv_postconditions_7_0= ruleCondition
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioDefAccess().getPostconditionsConditionParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_115);
            	    lv_postconditions_7_0=ruleCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"postconditions",
            	    							lv_postconditions_7_0,
            	    							"org.jucmnav.turn.Turn.Condition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop122;
                }
            } while (true);

            // InternalTurn.g:6625:3: (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==96) ) {
                    alt123=1;
                }


                switch (alt123) {
            	case 1 :
            	    // InternalTurn.g:6626:4: otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) )
            	    {
            	    otherlv_8=(Token)match(input,96,FOLLOW_3); 

            	    				newLeafNode(otherlv_8, grammarAccess.getScenarioDefAccess().getInitializeKeyword_6_0());
            	    			
            	    // InternalTurn.g:6630:4: ( (lv_initializations_9_0= ruleInitialization ) )
            	    // InternalTurn.g:6631:5: (lv_initializations_9_0= ruleInitialization )
            	    {
            	    // InternalTurn.g:6631:5: (lv_initializations_9_0= ruleInitialization )
            	    // InternalTurn.g:6632:6: lv_initializations_9_0= ruleInitialization
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioDefAccess().getInitializationsInitializationParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_116);
            	    lv_initializations_9_0=ruleInitialization();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"initializations",
            	    							lv_initializations_9_0,
            	    							"org.jucmnav.turn.Turn.Initialization");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop123;
                }
            } while (true);

            // InternalTurn.g:6650:3: (otherlv_10= 'start' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==64) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalTurn.g:6651:4: otherlv_10= 'start' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )*
                    {
                    otherlv_10=(Token)match(input,64,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getScenarioDefAccess().getStartKeyword_7_0());
                    			
                    // InternalTurn.g:6655:4: ( (otherlv_11= RULE_ID ) )
                    // InternalTurn.g:6656:5: (otherlv_11= RULE_ID )
                    {
                    // InternalTurn.g:6656:5: (otherlv_11= RULE_ID )
                    // InternalTurn.g:6657:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getScenarioDefRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_117); 

                    						newLeafNode(otherlv_11, grammarAccess.getScenarioDefAccess().getStartPointsStartPointCrossReference_7_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:6668:4: (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )*
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==23) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // InternalTurn.g:6669:5: otherlv_12= ',' ( (otherlv_13= RULE_ID ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getScenarioDefAccess().getCommaKeyword_7_2_0());
                    	    				
                    	    // InternalTurn.g:6673:5: ( (otherlv_13= RULE_ID ) )
                    	    // InternalTurn.g:6674:6: (otherlv_13= RULE_ID )
                    	    {
                    	    // InternalTurn.g:6674:6: (otherlv_13= RULE_ID )
                    	    // InternalTurn.g:6675:7: otherlv_13= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getScenarioDefRule());
                    	    							}
                    	    						
                    	    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_117); 

                    	    							newLeafNode(otherlv_13, grammarAccess.getScenarioDefAccess().getStartPointsStartPointCrossReference_7_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop124;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTurn.g:6688:3: (otherlv_14= 'end' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )* )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==81) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalTurn.g:6689:4: otherlv_14= 'end' ( (otherlv_15= RULE_ID ) ) (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )*
                    {
                    otherlv_14=(Token)match(input,81,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getScenarioDefAccess().getEndKeyword_8_0());
                    			
                    // InternalTurn.g:6693:4: ( (otherlv_15= RULE_ID ) )
                    // InternalTurn.g:6694:5: (otherlv_15= RULE_ID )
                    {
                    // InternalTurn.g:6694:5: (otherlv_15= RULE_ID )
                    // InternalTurn.g:6695:6: otherlv_15= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getScenarioDefRule());
                    						}
                    					
                    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_118); 

                    						newLeafNode(otherlv_15, grammarAccess.getScenarioDefAccess().getEndPointsEndPointCrossReference_8_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:6706:4: (otherlv_16= ',' ( (otherlv_17= RULE_ID ) ) )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==23) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // InternalTurn.g:6707:5: otherlv_16= ',' ( (otherlv_17= RULE_ID ) )
                    	    {
                    	    otherlv_16=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getScenarioDefAccess().getCommaKeyword_8_2_0());
                    	    				
                    	    // InternalTurn.g:6711:5: ( (otherlv_17= RULE_ID ) )
                    	    // InternalTurn.g:6712:6: (otherlv_17= RULE_ID )
                    	    {
                    	    // InternalTurn.g:6712:6: (otherlv_17= RULE_ID )
                    	    // InternalTurn.g:6713:7: otherlv_17= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getScenarioDefRule());
                    	    							}
                    	    						
                    	    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_118); 

                    	    							newLeafNode(otherlv_17, grammarAccess.getScenarioDefAccess().getEndPointsEndPointCrossReference_8_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop126;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTurn.g:6726:3: (otherlv_18= 'includes' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==48) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalTurn.g:6727:4: otherlv_18= 'includes' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )*
                    {
                    otherlv_18=(Token)match(input,48,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getScenarioDefAccess().getIncludesKeyword_9_0());
                    			
                    // InternalTurn.g:6731:4: ( (otherlv_19= RULE_ID ) )
                    // InternalTurn.g:6732:5: (otherlv_19= RULE_ID )
                    {
                    // InternalTurn.g:6732:5: (otherlv_19= RULE_ID )
                    // InternalTurn.g:6733:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getScenarioDefRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_47); 

                    						newLeafNode(otherlv_19, grammarAccess.getScenarioDefAccess().getIncludedScenariosScenarioDefCrossReference_9_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:6744:4: (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==23) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // InternalTurn.g:6745:5: otherlv_20= ',' ( (otherlv_21= RULE_ID ) )
                    	    {
                    	    otherlv_20=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getScenarioDefAccess().getCommaKeyword_9_2_0());
                    	    				
                    	    // InternalTurn.g:6749:5: ( (otherlv_21= RULE_ID ) )
                    	    // InternalTurn.g:6750:6: (otherlv_21= RULE_ID )
                    	    {
                    	    // InternalTurn.g:6750:6: (otherlv_21= RULE_ID )
                    	    // InternalTurn.g:6751:7: otherlv_21= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getScenarioDefRule());
                    	    							}
                    	    						
                    	    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_47); 

                    	    							newLeafNode(otherlv_21, grammarAccess.getScenarioDefAccess().getIncludedScenariosScenarioDefCrossReference_9_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop128;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_22=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_22, grammarAccess.getScenarioDefAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenarioDef"


    // $ANTLR start "entryRuleInitialization"
    // InternalTurn.g:6772:1: entryRuleInitialization returns [EObject current=null] : iv_ruleInitialization= ruleInitialization EOF ;
    public final EObject entryRuleInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialization = null;


        try {
            // InternalTurn.g:6772:55: (iv_ruleInitialization= ruleInitialization EOF )
            // InternalTurn.g:6773:2: iv_ruleInitialization= ruleInitialization EOF
            {
             newCompositeNode(grammarAccess.getInitializationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitialization=ruleInitialization();

            state._fsp--;

             current =iv_ruleInitialization; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitialization"


    // $ANTLR start "ruleInitialization"
    // InternalTurn.g:6779:1: ruleInitialization returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= ruleExpression ) ) | ( (lv_value_3_0= ruleEnumLiteral ) ) ) ) ;
    public final EObject ruleInitialization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6785:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= ruleExpression ) ) | ( (lv_value_3_0= ruleEnumLiteral ) ) ) ) )
            // InternalTurn.g:6786:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= ruleExpression ) ) | ( (lv_value_3_0= ruleEnumLiteral ) ) ) )
            {
            // InternalTurn.g:6786:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= ruleExpression ) ) | ( (lv_value_3_0= ruleEnumLiteral ) ) ) )
            // InternalTurn.g:6787:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= ruleExpression ) ) | ( (lv_value_3_0= ruleEnumLiteral ) ) )
            {
            // InternalTurn.g:6787:3: ( (otherlv_0= RULE_ID ) )
            // InternalTurn.g:6788:4: (otherlv_0= RULE_ID )
            {
            // InternalTurn.g:6788:4: (otherlv_0= RULE_ID )
            // InternalTurn.g:6789:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInitializationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_0, grammarAccess.getInitializationAccess().getVariableVariableCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getInitializationAccess().getEqualsSignKeyword_1());
            		
            // InternalTurn.g:6804:3: ( ( (lv_value_2_0= ruleExpression ) ) | ( (lv_value_3_0= ruleEnumLiteral ) ) )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==RULE_STRING) ) {
                alt130=1;
            }
            else if ( (LA130_0==RULE_ID) ) {
                alt130=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }
            switch (alt130) {
                case 1 :
                    // InternalTurn.g:6805:4: ( (lv_value_2_0= ruleExpression ) )
                    {
                    // InternalTurn.g:6805:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalTurn.g:6806:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalTurn.g:6806:5: (lv_value_2_0= ruleExpression )
                    // InternalTurn.g:6807:6: lv_value_2_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getInitializationAccess().getValueExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInitializationRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_2_0,
                    							"org.jucmnav.turn.Turn.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6825:4: ( (lv_value_3_0= ruleEnumLiteral ) )
                    {
                    // InternalTurn.g:6825:4: ( (lv_value_3_0= ruleEnumLiteral ) )
                    // InternalTurn.g:6826:5: (lv_value_3_0= ruleEnumLiteral )
                    {
                    // InternalTurn.g:6826:5: (lv_value_3_0= ruleEnumLiteral )
                    // InternalTurn.g:6827:6: lv_value_3_0= ruleEnumLiteral
                    {

                    						newCompositeNode(grammarAccess.getInitializationAccess().getValueEnumLiteralParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleEnumLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInitializationRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.jucmnav.turn.Turn.EnumLiteral");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitialization"


    // $ANTLR start "entryRuleVariable"
    // InternalTurn.g:6849:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalTurn.g:6849:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalTurn.g:6850:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalTurn.g:6856:1: ruleVariable returns [EObject current=null] : ( ( ( (lv_variableType_0_0= ruleVariableType ) ) | ( (otherlv_1= RULE_ID ) ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Enumerator lv_variableType_0_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6862:2: ( ( ( ( (lv_variableType_0_0= ruleVariableType ) ) | ( (otherlv_1= RULE_ID ) ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalTurn.g:6863:2: ( ( ( (lv_variableType_0_0= ruleVariableType ) ) | ( (otherlv_1= RULE_ID ) ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalTurn.g:6863:2: ( ( ( (lv_variableType_0_0= ruleVariableType ) ) | ( (otherlv_1= RULE_ID ) ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // InternalTurn.g:6864:3: ( ( (lv_variableType_0_0= ruleVariableType ) ) | ( (otherlv_1= RULE_ID ) ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalTurn.g:6864:3: ( ( (lv_variableType_0_0= ruleVariableType ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( ((LA131_0>=132 && LA131_0<=133)) ) {
                alt131=1;
            }
            else if ( (LA131_0==RULE_ID) ) {
                alt131=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // InternalTurn.g:6865:4: ( (lv_variableType_0_0= ruleVariableType ) )
                    {
                    // InternalTurn.g:6865:4: ( (lv_variableType_0_0= ruleVariableType ) )
                    // InternalTurn.g:6866:5: (lv_variableType_0_0= ruleVariableType )
                    {
                    // InternalTurn.g:6866:5: (lv_variableType_0_0= ruleVariableType )
                    // InternalTurn.g:6867:6: lv_variableType_0_0= ruleVariableType
                    {

                    						newCompositeNode(grammarAccess.getVariableAccess().getVariableTypeVariableTypeEnumRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_variableType_0_0=ruleVariableType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableRule());
                    						}
                    						set(
                    							current,
                    							"variableType",
                    							lv_variableType_0_0,
                    							"org.jucmnav.turn.Turn.VariableType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6885:4: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalTurn.g:6885:4: ( (otherlv_1= RULE_ID ) )
                    // InternalTurn.g:6886:5: (otherlv_1= RULE_ID )
                    {
                    // InternalTurn.g:6886:5: (otherlv_1= RULE_ID )
                    // InternalTurn.g:6887:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVariableRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_3); 

                    						newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getEnumerationTypeEnumerationTypeCrossReference_0_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:6899:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTurn.g:6900:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTurn.g:6900:4: (lv_name_2_0= RULE_ID )
            // InternalTurn.g:6901:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleEnumerationType"
    // InternalTurn.g:6921:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // InternalTurn.g:6921:56: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // InternalTurn.g:6922:2: iv_ruleEnumerationType= ruleEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationType=ruleEnumerationType();

            state._fsp--;

             current =iv_ruleEnumerationType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationType"


    // $ANTLR start "ruleEnumerationType"
    // InternalTurn.g:6928:1: ruleEnumerationType returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_values_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* ) ;
    public final EObject ruleEnumerationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_values_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6934:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_values_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* ) )
            // InternalTurn.g:6935:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_values_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* )
            {
            // InternalTurn.g:6935:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_values_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* )
            // InternalTurn.g:6936:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_values_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )*
            {
            otherlv_0=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationTypeAccess().getEnumKeyword_0());
            		
            // InternalTurn.g:6940:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTurn.g:6941:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTurn.g:6941:4: (lv_name_1_0= RULE_ID )
            // InternalTurn.g:6942:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumerationTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeAccess().getColonKeyword_2());
            		
            // InternalTurn.g:6962:3: ( (lv_values_3_0= ruleEnumLiteral ) )
            // InternalTurn.g:6963:4: (lv_values_3_0= ruleEnumLiteral )
            {
            // InternalTurn.g:6963:4: (lv_values_3_0= ruleEnumLiteral )
            // InternalTurn.g:6964:5: lv_values_3_0= ruleEnumLiteral
            {

            					newCompositeNode(grammarAccess.getEnumerationTypeAccess().getValuesEnumLiteralParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_values_3_0=ruleEnumLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_3_0,
            						"org.jucmnav.turn.Turn.EnumLiteral");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:6981:3: (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )*
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==23) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // InternalTurn.g:6982:4: otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_25); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalTurn.g:6986:4: ( (lv_values_5_0= ruleEnumLiteral ) )
            	    // InternalTurn.g:6987:5: (lv_values_5_0= ruleEnumLiteral )
            	    {
            	    // InternalTurn.g:6987:5: (lv_values_5_0= ruleEnumLiteral )
            	    // InternalTurn.g:6988:6: lv_values_5_0= ruleEnumLiteral
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getValuesEnumLiteralParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_values_5_0=ruleEnumLiteral();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_5_0,
            	    							"org.jucmnav.turn.Turn.EnumLiteral");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop132;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationType"


    // $ANTLR start "entryRuleExpression"
    // InternalTurn.g:7010:1: entryRuleExpression returns [String current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final String entryRuleExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExpression = null;


        try {
            // InternalTurn.g:7010:50: (iv_ruleExpression= ruleExpression EOF )
            // InternalTurn.g:7011:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalTurn.g:7017:1: ruleExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7023:2: (this_STRING_0= RULE_STRING )
            // InternalTurn.g:7024:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            		current.merge(this_STRING_0);
            	

            		newLeafNode(this_STRING_0, grammarAccess.getExpressionAccess().getSTRINGTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalTurn.g:7034:1: entryRuleEnumLiteral returns [String current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final String entryRuleEnumLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEnumLiteral = null;


        try {
            // InternalTurn.g:7034:51: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalTurn.g:7035:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;

             current =iv_ruleEnumLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalTurn.g:7041:1: ruleEnumLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleEnumLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7047:2: (this_ID_0= RULE_ID )
            // InternalTurn.g:7048:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getEnumLiteralAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "entryRulePositiveInteger"
    // InternalTurn.g:7058:1: entryRulePositiveInteger returns [String current=null] : iv_rulePositiveInteger= rulePositiveInteger EOF ;
    public final String entryRulePositiveInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePositiveInteger = null;


        try {
            // InternalTurn.g:7058:55: (iv_rulePositiveInteger= rulePositiveInteger EOF )
            // InternalTurn.g:7059:2: iv_rulePositiveInteger= rulePositiveInteger EOF
            {
             newCompositeNode(grammarAccess.getPositiveIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePositiveInteger=rulePositiveInteger();

            state._fsp--;

             current =iv_rulePositiveInteger.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePositiveInteger"


    // $ANTLR start "rulePositiveInteger"
    // InternalTurn.g:7065:1: rulePositiveInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken rulePositiveInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7071:2: (this_INT_0= RULE_INT )
            // InternalTurn.g:7072:2: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            		current.merge(this_INT_0);
            	

            		newLeafNode(this_INT_0, grammarAccess.getPositiveIntegerAccess().getINTTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePositiveInteger"


    // $ANTLR start "ruleQualitativeLabel"
    // InternalTurn.g:7082:1: ruleQualitativeLabel returns [Enumerator current=null] : ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) ;
    public final Enumerator ruleQualitativeLabel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalTurn.g:7088:2: ( ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) )
            // InternalTurn.g:7089:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            {
            // InternalTurn.g:7089:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            int alt133=7;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt133=1;
                }
                break;
            case 99:
                {
                alt133=2;
                }
                break;
            case 100:
                {
                alt133=3;
                }
                break;
            case 101:
                {
                alt133=4;
                }
                break;
            case 102:
                {
                alt133=5;
                }
                break;
            case 103:
                {
                alt133=6;
                }
                break;
            case 104:
                {
                alt133=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // InternalTurn.g:7090:3: (enumLiteral_0= 'denied' )
                    {
                    // InternalTurn.g:7090:3: (enumLiteral_0= 'denied' )
                    // InternalTurn.g:7091:4: enumLiteral_0= 'denied'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7098:3: (enumLiteral_1= 'weaklyDenied' )
                    {
                    // InternalTurn.g:7098:3: (enumLiteral_1= 'weaklyDenied' )
                    // InternalTurn.g:7099:4: enumLiteral_1= 'weaklyDenied'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7106:3: (enumLiteral_2= 'weaklySatisfied' )
                    {
                    // InternalTurn.g:7106:3: (enumLiteral_2= 'weaklySatisfied' )
                    // InternalTurn.g:7107:4: enumLiteral_2= 'weaklySatisfied'
                    {
                    enumLiteral_2=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7114:3: (enumLiteral_3= 'satisfied' )
                    {
                    // InternalTurn.g:7114:3: (enumLiteral_3= 'satisfied' )
                    // InternalTurn.g:7115:4: enumLiteral_3= 'satisfied'
                    {
                    enumLiteral_3=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7122:3: (enumLiteral_4= 'conflict' )
                    {
                    // InternalTurn.g:7122:3: (enumLiteral_4= 'conflict' )
                    // InternalTurn.g:7123:4: enumLiteral_4= 'conflict'
                    {
                    enumLiteral_4=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7130:3: (enumLiteral_5= 'unknown' )
                    {
                    // InternalTurn.g:7130:3: (enumLiteral_5= 'unknown' )
                    // InternalTurn.g:7131:4: enumLiteral_5= 'unknown'
                    {
                    enumLiteral_5=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTurn.g:7138:3: (enumLiteral_6= 'none' )
                    {
                    // InternalTurn.g:7138:3: (enumLiteral_6= 'none' )
                    // InternalTurn.g:7139:4: enumLiteral_6= 'none'
                    {
                    enumLiteral_6=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getNoneEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getQualitativeLabelAccess().getNoneEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualitativeLabel"


    // $ANTLR start "ruleIntentionalElementType"
    // InternalTurn.g:7149:1: ruleIntentionalElementType returns [Enumerator current=null] : ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) ;
    public final Enumerator ruleIntentionalElementType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTurn.g:7155:2: ( ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) )
            // InternalTurn.g:7156:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            {
            // InternalTurn.g:7156:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            int alt134=6;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt134=1;
                }
                break;
            case 106:
                {
                alt134=2;
                }
                break;
            case 107:
                {
                alt134=3;
                }
                break;
            case 108:
                {
                alt134=4;
                }
                break;
            case 109:
                {
                alt134=5;
                }
                break;
            case 110:
                {
                alt134=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }

            switch (alt134) {
                case 1 :
                    // InternalTurn.g:7157:3: (enumLiteral_0= 'softgoal' )
                    {
                    // InternalTurn.g:7157:3: (enumLiteral_0= 'softgoal' )
                    // InternalTurn.g:7158:4: enumLiteral_0= 'softgoal'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7165:3: (enumLiteral_1= 'goal' )
                    {
                    // InternalTurn.g:7165:3: (enumLiteral_1= 'goal' )
                    // InternalTurn.g:7166:4: enumLiteral_1= 'goal'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7173:3: (enumLiteral_2= 'task' )
                    {
                    // InternalTurn.g:7173:3: (enumLiteral_2= 'task' )
                    // InternalTurn.g:7174:4: enumLiteral_2= 'task'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7181:3: (enumLiteral_3= 'resource' )
                    {
                    // InternalTurn.g:7181:3: (enumLiteral_3= 'resource' )
                    // InternalTurn.g:7182:4: enumLiteral_3= 'resource'
                    {
                    enumLiteral_3=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7189:3: (enumLiteral_4= 'belief' )
                    {
                    // InternalTurn.g:7189:3: (enumLiteral_4= 'belief' )
                    // InternalTurn.g:7190:4: enumLiteral_4= 'belief'
                    {
                    enumLiteral_4=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7197:3: (enumLiteral_5= 'indicator' )
                    {
                    // InternalTurn.g:7197:3: (enumLiteral_5= 'indicator' )
                    // InternalTurn.g:7198:4: enumLiteral_5= 'indicator'
                    {
                    enumLiteral_5=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getIndicatorEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getIntentionalElementTypeAccess().getIndicatorEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentionalElementType"


    // $ANTLR start "ruleContributionType"
    // InternalTurn.g:7208:1: ruleContributionType returns [Enumerator current=null] : ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) ) ;
    public final Enumerator ruleContributionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalTurn.g:7214:2: ( ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) ) )
            // InternalTurn.g:7215:2: ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) )
            {
            // InternalTurn.g:7215:2: ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) )
            int alt135=7;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt135=1;
                }
                break;
            case 112:
                {
                alt135=2;
                }
                break;
            case 113:
                {
                alt135=3;
                }
                break;
            case 103:
                {
                alt135=4;
                }
                break;
            case 114:
                {
                alt135=5;
                }
                break;
            case 115:
                {
                alt135=6;
                }
                break;
            case 116:
                {
                alt135=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }

            switch (alt135) {
                case 1 :
                    // InternalTurn.g:7216:3: (enumLiteral_0= 'make' )
                    {
                    // InternalTurn.g:7216:3: (enumLiteral_0= 'make' )
                    // InternalTurn.g:7217:4: enumLiteral_0= 'make'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7224:3: (enumLiteral_1= 'help' )
                    {
                    // InternalTurn.g:7224:3: (enumLiteral_1= 'help' )
                    // InternalTurn.g:7225:4: enumLiteral_1= 'help'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7232:3: (enumLiteral_2= 'somePositive' )
                    {
                    // InternalTurn.g:7232:3: (enumLiteral_2= 'somePositive' )
                    // InternalTurn.g:7233:4: enumLiteral_2= 'somePositive'
                    {
                    enumLiteral_2=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7240:3: (enumLiteral_3= 'unknown' )
                    {
                    // InternalTurn.g:7240:3: (enumLiteral_3= 'unknown' )
                    // InternalTurn.g:7241:4: enumLiteral_3= 'unknown'
                    {
                    enumLiteral_3=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7248:3: (enumLiteral_4= 'someNegative' )
                    {
                    // InternalTurn.g:7248:3: (enumLiteral_4= 'someNegative' )
                    // InternalTurn.g:7249:4: enumLiteral_4= 'someNegative'
                    {
                    enumLiteral_4=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7256:3: (enumLiteral_5= 'hurt' )
                    {
                    // InternalTurn.g:7256:3: (enumLiteral_5= 'hurt' )
                    // InternalTurn.g:7257:4: enumLiteral_5= 'hurt'
                    {
                    enumLiteral_5=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTurn.g:7264:3: (enumLiteral_6= 'break' )
                    {
                    // InternalTurn.g:7264:3: (enumLiteral_6= 'break' )
                    // InternalTurn.g:7265:4: enumLiteral_6= 'break'
                    {
                    enumLiteral_6=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getBreakEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getContributionTypeAccess().getBreakEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionType"


    // $ANTLR start "ruleImportanceType"
    // InternalTurn.g:7275:1: ruleImportanceType returns [Enumerator current=null] : ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) ;
    public final Enumerator ruleImportanceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTurn.g:7281:2: ( ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) )
            // InternalTurn.g:7282:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            {
            // InternalTurn.g:7282:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            int alt136=4;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt136=1;
                }
                break;
            case 118:
                {
                alt136=2;
                }
                break;
            case 119:
                {
                alt136=3;
                }
                break;
            case 104:
                {
                alt136=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }

            switch (alt136) {
                case 1 :
                    // InternalTurn.g:7283:3: (enumLiteral_0= 'high' )
                    {
                    // InternalTurn.g:7283:3: (enumLiteral_0= 'high' )
                    // InternalTurn.g:7284:4: enumLiteral_0= 'high'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7291:3: (enumLiteral_1= 'medium' )
                    {
                    // InternalTurn.g:7291:3: (enumLiteral_1= 'medium' )
                    // InternalTurn.g:7292:4: enumLiteral_1= 'medium'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7299:3: (enumLiteral_2= 'low' )
                    {
                    // InternalTurn.g:7299:3: (enumLiteral_2= 'low' )
                    // InternalTurn.g:7300:4: enumLiteral_2= 'low'
                    {
                    enumLiteral_2=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7307:3: (enumLiteral_3= 'none' )
                    {
                    // InternalTurn.g:7307:3: (enumLiteral_3= 'none' )
                    // InternalTurn.g:7308:4: enumLiteral_3= 'none'
                    {
                    enumLiteral_3=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getNoneEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getImportanceTypeAccess().getNoneEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportanceType"


    // $ANTLR start "ruleDecompositionType"
    // InternalTurn.g:7318:1: ruleDecompositionType returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) ;
    public final Enumerator ruleDecompositionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTurn.g:7324:2: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) )
            // InternalTurn.g:7325:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            {
            // InternalTurn.g:7325:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            int alt137=3;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt137=1;
                }
                break;
            case 82:
                {
                alt137=2;
                }
                break;
            case 120:
                {
                alt137=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // InternalTurn.g:7326:3: (enumLiteral_0= 'and' )
                    {
                    // InternalTurn.g:7326:3: (enumLiteral_0= 'and' )
                    // InternalTurn.g:7327:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7334:3: (enumLiteral_1= 'or' )
                    {
                    // InternalTurn.g:7334:3: (enumLiteral_1= 'or' )
                    // InternalTurn.g:7335:4: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7342:3: (enumLiteral_2= 'xor' )
                    {
                    // InternalTurn.g:7342:3: (enumLiteral_2= 'xor' )
                    // InternalTurn.g:7343:4: enumLiteral_2= 'xor'
                    {
                    enumLiteral_2=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getXorEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDecompositionTypeAccess().getXorEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecompositionType"


    // $ANTLR start "ruleWaitKind"
    // InternalTurn.g:7353:1: ruleWaitKind returns [Enumerator current=null] : ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) ;
    public final Enumerator ruleWaitKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTurn.g:7359:2: ( ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) )
            // InternalTurn.g:7360:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            {
            // InternalTurn.g:7360:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==121) ) {
                alt138=1;
            }
            else if ( (LA138_0==122) ) {
                alt138=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }
            switch (alt138) {
                case 1 :
                    // InternalTurn.g:7361:3: (enumLiteral_0= 'persistent' )
                    {
                    // InternalTurn.g:7361:3: (enumLiteral_0= 'persistent' )
                    // InternalTurn.g:7362:4: enumLiteral_0= 'persistent'
                    {
                    enumLiteral_0=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getWaitKindAccess().getPersistentEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getWaitKindAccess().getPersistentEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7369:3: (enumLiteral_1= 'transient' )
                    {
                    // InternalTurn.g:7369:3: (enumLiteral_1= 'transient' )
                    // InternalTurn.g:7370:4: enumLiteral_1= 'transient'
                    {
                    enumLiteral_1=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getWaitKindAccess().getTransientEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getWaitKindAccess().getTransientEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWaitKind"


    // $ANTLR start "ruleComponentKind"
    // InternalTurn.g:7380:1: ruleComponentKind returns [Enumerator current=null] : ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) ;
    public final Enumerator ruleComponentKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTurn.g:7386:2: ( ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) )
            // InternalTurn.g:7387:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            {
            // InternalTurn.g:7387:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            int alt139=6;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt139=1;
                }
                break;
            case 124:
                {
                alt139=2;
                }
                break;
            case 125:
                {
                alt139=3;
                }
                break;
            case 126:
                {
                alt139=4;
                }
                break;
            case 38:
                {
                alt139=5;
                }
                break;
            case 127:
                {
                alt139=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }

            switch (alt139) {
                case 1 :
                    // InternalTurn.g:7388:3: (enumLiteral_0= 'team' )
                    {
                    // InternalTurn.g:7388:3: (enumLiteral_0= 'team' )
                    // InternalTurn.g:7389:4: enumLiteral_0= 'team'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getComponentKindAccess().getTeamEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComponentKindAccess().getTeamEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7396:3: (enumLiteral_1= 'object' )
                    {
                    // InternalTurn.g:7396:3: (enumLiteral_1= 'object' )
                    // InternalTurn.g:7397:4: enumLiteral_1= 'object'
                    {
                    enumLiteral_1=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getComponentKindAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComponentKindAccess().getObjectEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7404:3: (enumLiteral_2= 'process' )
                    {
                    // InternalTurn.g:7404:3: (enumLiteral_2= 'process' )
                    // InternalTurn.g:7405:4: enumLiteral_2= 'process'
                    {
                    enumLiteral_2=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getComponentKindAccess().getProcessEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComponentKindAccess().getProcessEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7412:3: (enumLiteral_3= 'agent' )
                    {
                    // InternalTurn.g:7412:3: (enumLiteral_3= 'agent' )
                    // InternalTurn.g:7413:4: enumLiteral_3= 'agent'
                    {
                    enumLiteral_3=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getComponentKindAccess().getAgentEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComponentKindAccess().getAgentEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7420:3: (enumLiteral_4= 'actor' )
                    {
                    // InternalTurn.g:7420:3: (enumLiteral_4= 'actor' )
                    // InternalTurn.g:7421:4: enumLiteral_4= 'actor'
                    {
                    enumLiteral_4=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getComponentKindAccess().getActorEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComponentKindAccess().getActorEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7428:3: (enumLiteral_5= 'parent' )
                    {
                    // InternalTurn.g:7428:3: (enumLiteral_5= 'parent' )
                    // InternalTurn.g:7429:4: enumLiteral_5= 'parent'
                    {
                    enumLiteral_5=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getComponentKindAccess().getParentEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComponentKindAccess().getParentEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentKind"


    // $ANTLR start "ruleFailureKind"
    // InternalTurn.g:7439:1: ruleFailureKind returns [Enumerator current=null] : ( (enumLiteral_0= 'abort' ) | (enumLiteral_1= 'failure' ) ) ;
    public final Enumerator ruleFailureKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTurn.g:7445:2: ( ( (enumLiteral_0= 'abort' ) | (enumLiteral_1= 'failure' ) ) )
            // InternalTurn.g:7446:2: ( (enumLiteral_0= 'abort' ) | (enumLiteral_1= 'failure' ) )
            {
            // InternalTurn.g:7446:2: ( (enumLiteral_0= 'abort' ) | (enumLiteral_1= 'failure' ) )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==128) ) {
                alt140=1;
            }
            else if ( (LA140_0==129) ) {
                alt140=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }
            switch (alt140) {
                case 1 :
                    // InternalTurn.g:7447:3: (enumLiteral_0= 'abort' )
                    {
                    // InternalTurn.g:7447:3: (enumLiteral_0= 'abort' )
                    // InternalTurn.g:7448:4: enumLiteral_0= 'abort'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getFailureKindAccess().getAbortEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFailureKindAccess().getAbortEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7455:3: (enumLiteral_1= 'failure' )
                    {
                    // InternalTurn.g:7455:3: (enumLiteral_1= 'failure' )
                    // InternalTurn.g:7456:4: enumLiteral_1= 'failure'
                    {
                    enumLiteral_1=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getFailureKindAccess().getFailureEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFailureKindAccess().getFailureEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailureKind"


    // $ANTLR start "ruleStubType"
    // InternalTurn.g:7466:1: ruleStubType returns [Enumerator current=null] : ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) ) ;
    public final Enumerator ruleStubType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTurn.g:7472:2: ( ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) ) )
            // InternalTurn.g:7473:2: ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) )
            {
            // InternalTurn.g:7473:2: ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==130) ) {
                alt141=1;
            }
            else if ( (LA141_0==131) ) {
                alt141=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // InternalTurn.g:7474:3: (enumLiteral_0= 'synchronizing' )
                    {
                    // InternalTurn.g:7474:3: (enumLiteral_0= 'synchronizing' )
                    // InternalTurn.g:7475:4: enumLiteral_0= 'synchronizing'
                    {
                    enumLiteral_0=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getStubTypeAccess().getSynchronizingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStubTypeAccess().getSynchronizingEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7482:3: (enumLiteral_1= 'blocking' )
                    {
                    // InternalTurn.g:7482:3: (enumLiteral_1= 'blocking' )
                    // InternalTurn.g:7483:4: enumLiteral_1= 'blocking'
                    {
                    enumLiteral_1=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getStubTypeAccess().getBlockingEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStubTypeAccess().getBlockingEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubType"


    // $ANTLR start "ruleVariableType"
    // InternalTurn.g:7493:1: ruleVariableType returns [Enumerator current=null] : ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'int' ) ) ;
    public final Enumerator ruleVariableType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTurn.g:7499:2: ( ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'int' ) ) )
            // InternalTurn.g:7500:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'int' ) )
            {
            // InternalTurn.g:7500:2: ( (enumLiteral_0= 'bool' ) | (enumLiteral_1= 'int' ) )
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==132) ) {
                alt142=1;
            }
            else if ( (LA142_0==133) ) {
                alt142=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }
            switch (alt142) {
                case 1 :
                    // InternalTurn.g:7501:3: (enumLiteral_0= 'bool' )
                    {
                    // InternalTurn.g:7501:3: (enumLiteral_0= 'bool' )
                    // InternalTurn.g:7502:4: enumLiteral_0= 'bool'
                    {
                    enumLiteral_0=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getBoolEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVariableTypeAccess().getBoolEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7509:3: (enumLiteral_1= 'int' )
                    {
                    // InternalTurn.g:7509:3: (enumLiteral_1= 'int' )
                    // InternalTurn.g:7510:4: enumLiteral_1= 'int'
                    {
                    enumLiteral_1=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getVariableTypeAccess().getIntEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVariableTypeAccess().getIntEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableType"

    // Delegated rules


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA104 dfa104 = new DFA104(this);
    protected DFA118 dfa118 = new DFA118(this);
    protected DFA119 dfa119 = new DFA119(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\1\1\21\uffff";
    static final String dfa_3s = "\1\5\21\uffff";
    static final String dfa_4s = "\1\u0085\21\uffff";
    static final String dfa_5s = "\1\uffff\1\21\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20";
    static final String dfa_6s = "\1\0\21\uffff}>";
    static final String[] dfa_7s = {
            "\1\15\5\uffff\1\2\1\4\10\uffff\1\17\4\uffff\1\20\2\uffff\1\21\10\uffff\1\3\7\uffff\1\5\1\6\5\uffff\1\7\3\uffff\1\7\1\10\1\11\2\uffff\2\12\34\uffff\1\13\1\14\3\uffff\1\16\42\uffff\2\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_0==EOF) ) {s = 1;}

                        else if ( LA16_0 == 11 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0) ) {s = 2;}

                        else if ( LA16_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1) ) {s = 3;}

                        else if ( LA16_0 == 12 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2) ) {s = 4;}

                        else if ( LA16_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3) ) {s = 5;}

                        else if ( LA16_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4) ) {s = 6;}

                        else if ( ( LA16_0 == 53 || LA16_0 == 57 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5) ) {s = 7;}

                        else if ( LA16_0 == 58 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6) ) {s = 8;}

                        else if ( LA16_0 == 59 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7) ) {s = 9;}

                        else if ( LA16_0 >= 62 && LA16_0 <= 63 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8) ) {s = 10;}

                        else if ( LA16_0 == 92 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {s = 11;}

                        else if ( LA16_0 == 93 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {s = 12;}

                        else if ( ( LA16_0 == RULE_ID || LA16_0 >= 132 && LA16_0 <= 133 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {s = 13;}

                        else if ( LA16_0 == 97 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12) ) {s = 14;}

                        else if ( LA16_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13) ) {s = 15;}

                        else if ( LA16_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14) ) {s = 16;}

                        else if ( LA16_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15) ) {s = 17;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\6\uffff";
    static final String dfa_9s = "\1\5\1\26\1\uffff\1\5\1\uffff\1\26";
    static final String dfa_10s = "\1\33\1\45\1\uffff\1\5\1\uffff\1\45";
    static final String dfa_11s = "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_12s = "\6\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\25\uffff\1\2",
            "\1\4\5\uffff\1\2\2\uffff\1\4\5\uffff\1\3",
            "",
            "\1\5",
            "",
            "\1\4\5\uffff\1\2\2\uffff\1\4\5\uffff\1\3"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "995:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?";
        }
    }
    static final String dfa_14s = "\12\uffff";
    static final String dfa_15s = "\1\5\1\37\3\uffff\1\5\1\4\1\37\2\51";
    static final String dfa_16s = "\2\170\3\uffff\2\5\3\170";
    static final String dfa_17s = "\2\uffff\1\1\1\2\1\3\5\uffff";
    static final String dfa_18s = "\12\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\43\uffff\1\2\3\uffff\1\4\44\uffff\1\3\1\uffff\1\3\43\uffff\1\3",
            "\1\6\5\uffff\1\5\3\uffff\1\2\3\uffff\1\4\44\uffff\1\3\1\uffff\1\3\43\uffff\1\3",
            "",
            "",
            "",
            "\1\7",
            "\1\11\1\10",
            "\1\6\5\uffff\1\5\3\uffff\1\2\3\uffff\1\4\44\uffff\1\3\1\uffff\1\3\43\uffff\1\3",
            "\1\2\3\uffff\1\4\44\uffff\1\3\1\uffff\1\3\43\uffff\1\3",
            "\1\2\3\uffff\1\4\44\uffff\1\3\1\uffff\1\3\43\uffff\1\3"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1761:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )";
        }
    }
    static final String dfa_20s = "\11\uffff";
    static final String dfa_21s = "\1\5\1\uffff\2\5\1\4\1\uffff\3\5";
    static final String dfa_22s = "\1\u0081\1\uffff\1\177\2\5\1\uffff\3\177";
    static final String dfa_23s = "\1\uffff\1\2\3\uffff\1\1\3\uffff";
    static final String dfa_24s = "\11\uffff}>";
    static final String[] dfa_25s = {
            "\1\2\16\uffff\1\1\21\uffff\1\1\31\uffff\1\1\31\uffff\1\1\40\uffff\7\1",
            "",
            "\1\1\16\uffff\1\1\1\uffff\1\1\7\uffff\1\5\1\4\5\uffff\1\3\1\1\63\uffff\1\1\40\uffff\5\1",
            "\1\6",
            "\1\10\1\7",
            "",
            "\1\1\16\uffff\1\1\1\uffff\1\1\7\uffff\1\5\1\4\5\uffff\1\3\1\1\63\uffff\1\1\40\uffff\5\1",
            "\1\1\16\uffff\1\1\1\uffff\1\1\7\uffff\1\5\7\uffff\1\1\63\uffff\1\1\40\uffff\5\1",
            "\1\1\16\uffff\1\1\1\uffff\1\1\7\uffff\1\5\7\uffff\1\1\63\uffff\1\1\40\uffff\5\1"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "()* loopback of 3409:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*";
        }
    }
    static final String dfa_26s = "\1\107\3\uffff\2\114\4\uffff";
    static final String dfa_27s = "\1\172\3\uffff\2\115\4\uffff";
    static final String dfa_28s = "\1\uffff\1\1\1\2\1\3\2\uffff\1\4\1\5\1\6\1\7";
    static final String[] dfa_29s = {
            "\1\2\1\3\3\1\1\6\1\10\1\uffff\1\11\1\7\50\uffff\1\4\1\5",
            "",
            "",
            "",
            "\1\6\1\10",
            "\1\6\1\10",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_18;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "3990:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )";
        }
    }
    static final String dfa_30s = "\1\uffff\1\4\3\uffff\1\4";
    static final String dfa_31s = "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String dfa_32s = "\1\126\1\u0081\1\uffff\1\5\1\uffff\1\u0081";
    static final String dfa_33s = "\2\uffff\1\1\1\uffff\1\2\1\uffff";
    static final String[] dfa_34s = {
            "\1\1\120\uffff\1\2",
            "\1\4\7\uffff\1\4\6\uffff\1\4\3\uffff\1\4\6\uffff\1\2\4\uffff\1\4\1\3\1\4\31\uffff\1\4\5\uffff\1\4\14\uffff\1\4\2\uffff\1\2\1\uffff\1\4\1\uffff\1\4\40\uffff\7\4",
            "",
            "\1\5",
            "",
            "\1\4\7\uffff\1\4\6\uffff\1\4\3\uffff\1\4\6\uffff\1\2\4\uffff\1\4\1\3\1\4\31\uffff\1\4\5\uffff\1\4\14\uffff\1\4\2\uffff\1\2\1\uffff\1\4\1\uffff\1\4\40\uffff\7\4"
    };
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA104 extends DFA {

        public DFA104(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 104;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_12;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "5395:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )";
        }
    }
    static final String dfa_35s = "\3\5\2\uffff\1\5";
    static final String dfa_36s = "\1\5\1\177\1\5\2\uffff\1\177";
    static final String dfa_37s = "\3\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_38s = {
            "\1\1",
            "\1\4\16\uffff\1\4\2\uffff\1\4\15\uffff\1\2\1\4\63\uffff\1\4\1\3\37\uffff\5\4",
            "\1\5",
            "",
            "",
            "\1\4\16\uffff\1\4\2\uffff\1\4\15\uffff\1\2\1\4\63\uffff\1\4\1\3\37\uffff\5\4"
    };
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA118 extends DFA {

        public DFA118(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 118;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_12;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "6028:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )";
        }
    }
    static final String dfa_39s = "\10\uffff";
    static final String dfa_40s = "\1\5\1\36\2\5\1\36\3\uffff";
    static final String dfa_41s = "\1\5\1\45\1\5\1\130\1\45\3\uffff";
    static final String dfa_42s = "\5\uffff\1\1\1\2\1\3";
    static final String dfa_43s = "\10\uffff}>";
    static final String[] dfa_44s = {
            "\1\1",
            "\1\3\6\uffff\1\2",
            "\1\4",
            "\1\7\77\uffff\1\5\22\uffff\1\6",
            "\1\3\6\uffff\1\2",
            "",
            "",
            ""
    };

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA119 extends DFA {

        public DFA119(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 119;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "6158:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xCE20C04024203822L,0x0000000230000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000080400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001F80000060L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001F80000062L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000008000100000L,0x00007E0000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x3000000000000040L,0x00E0010000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000100000L,0x00007E0000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000238000100020L,0x0100000000140000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000230000100020L,0x0100000000140000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000220000100020L,0x0100000000140000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020080000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x3000000000000040L,0x00FF818000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000080000020L,0x0100000000140000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000020L,0x0100000000140000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000200080000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001000000108020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0001000000100020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0016000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x3000000000000040L,0x00E001FC00000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0012000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0012000000100000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000004000100020L,0xF800000004000001L,0x0000000000000003L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000004000100020L,0xF800000004000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000001000022L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000360000L,0x000000000000000CL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000022L,0x0000000000000010L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x060000000001BF80L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x060000000001BF80L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000001002022L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000081002000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000001002002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000001100000L,0x0000000000004040L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000001100000L,0x0000000000000040L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000001000022L,0x0000000000000004L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000081000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000001000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000002001000020L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000002081000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000002001000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000001002020L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000001000100000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000020L,0x0000000000400020L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000020L,0x0000000000400000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000080000020L,0x0000000000400000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000002002L,0x0000000000000040L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000100000L,0x0000000001000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000001000020L,0x0000000002800000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000020L,0x0000000002000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000004000000020L,0xF800000000000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0001000000100000L,0x00000001C0020001L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0001000000100000L,0x0000000180020001L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0001000000100000L,0x0000000100020001L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0001000000900000L,0x0000000000020000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0001000000900000L});

}
